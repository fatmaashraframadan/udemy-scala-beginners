package lectures.part3fp

import java.util.Random
import scala.util.{Failure, Success, Try}

object HandlingFailure extends App {
  val aSuccess = Success(3)
  val aFailure = Failure(new RuntimeException())

  println(aSuccess)
  println(aFailure)

  def unSafeMethod(): String = throw new RuntimeException("No String For you")

  val potentialFailure = Try(unSafeMethod())
  println(potentialFailure)

  val anotherPotentialFailure = Try {

  }
  println(potentialFailure.isSuccess)

  def backUpMethod(): String = "A valid String"

  val fallbacktry = Try(unSafeMethod()).orElse(Try(backUpMethod()))

  println(fallbacktry)

  def betterUnSafeMethod(): Try[String] = Failure(new RuntimeException())

  def betterBackUpMethod(): Try[String] = Success("Valid result")

  val btterFallBack = betterUnSafeMethod() orElse betterBackUpMethod()
  println(btterFallBack)

  //map, Flatmap, filter
  println(aSuccess.map(_ * 2))
  println(aSuccess.flatMap(x => Success(x * 10)))
  println(aSuccess.filter(x => x > 10))

  //for comprehensions

  /*
  * Exercise
  * */

  val hostname = "localhost"
  val port = "8080"

  def renderHTML(page: String): Unit = println(page)

  class Connection {
    def get(url: String): String = {
      val random = new Random(System.nanoTime)
      if (random.nextBoolean()) "<html>...</html>"
      else throw new RuntimeException("Connection is flaky")
    }

    def safeGet(url: String): Try[String] = Try(get(url))
  }

  object HTTPService {
    val random = new Random(System.nanoTime)

    def getConnection(host: String, port: String): Connection = {
      if (random.nextBoolean()) new Connection
      else throw new RuntimeException("port is taken")
    }

    def safeGetConnection(host: String, port: String): Try[Connection] = Try(getConnection(host, port))
  }

  val possibleConnection = HTTPService.safeGetConnection(hostname, port)
  val possibleHTML = possibleConnection.flatMap(connection => connection.safeGet("/home"))

  possibleHTML.foreach(renderHTML)

  HTTPService.safeGetConnection(hostname, port)
    .flatMap(connection => connection.safeGet("/home"))
    .foreach(renderHTML)

  for {
    connection <- HTTPService.safeGetConnection(hostname, port)
    HTML <- connection.safeGet("/home")
  } yield renderHTML(HTML)

}
