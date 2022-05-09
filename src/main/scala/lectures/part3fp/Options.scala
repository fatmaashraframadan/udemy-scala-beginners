package lectures.part3fp

import java.util.Random

object Options extends App {
  val myFirstOption: Option[Int] = Some(15)
  val anOtherOption: Option[Int] = None

  println(myFirstOption)
  println(anOtherOption)

  def unSafeMethod(): String = null

  val result = Option(unSafeMethod())
  println(result)

  def backupMethod(): String = "Valid String"

  val chainedResult = Option(unSafeMethod()).orElse(Option(backupMethod()))

  // DESIGN unsafe APIs
  def betterUnSafeMethod(): Option[String] = None

  def betterBackupMethod(): Option[String] = Some("Valid String")

  val betterChainedResult = betterUnSafeMethod() orElse betterBackupMethod()

  //functions on Options
  println(myFirstOption.isEmpty)
  println(myFirstOption.get) //UnSafe

  // map, Flatmap, Filter
  println(myFirstOption.map(_ * 2))
  println(myFirstOption.filter(x => x > 30))
  println(myFirstOption.flatMap(x => Option(x * 10)))

  // for-comprehensions

  /*
    Exercise.
   */
  val config: Map[String, String] = Map(
    // fetched from elsewhere
    "host" -> "176.45.36.1",
    "port" -> "80"
  )

  class Connection {
    def connect = "Connected" // connect to some server
  }

  object Connection {
    val random = new Random(System.nanoTime())

    def apply(host: String, port: String): Option[Connection] =
      if (random.nextBoolean()) Some(new Connection)
      else None
  }

  val host = config.get("host")
  val port = config.get("port")

  val connection = host.flatMap(h => port.flatMap(p => Connection.apply(h, p)))
  val connectionstatus = connection.map(c => c.connect)
  println(connectionstatus)

  val forConnectionStatus = for {
    host <- config.get("host")
    port <- config.get("port")
    connection <- Connection(host, port)
  } yield connection.connect

  forConnectionStatus.foreach(println)

}
