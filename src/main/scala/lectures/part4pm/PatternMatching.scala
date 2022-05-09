package lectures.part4pm

import java.util.Random

object PatternMatching extends App {
  val random = new Random().nextInt(10)

  //pattern matching to match value against multiple patterns like switch
  val description = random match {
    case 1 => "The ONE"
    case 2 => "Double or nothing"
    case 3 => "third time is the charm"
    case _ => "WildCard"
  }

  println(random)
  println(description)

  //1. Decompose values
  case class Person(nams: String, age: Int)

  val person = new Person("Bob", 20)

  val greeting = person match {
    case Person(n, a) if a < 21 => s"Hello, I'm ${n} and my age is ${a} years old and i can drink in the US."
    case _ => "I don't know who i am"
  }

  println(greeting)

  //PM on sealed classes
  sealed class Animal

  case class Dog(breed: String) extends Animal

  case class Parrot(greeting: String) extends Animal

  val animal: Animal = Dog("Terra Nova")

  animal match {
    case Dog(b) => "This is Dog"
  }

  /*
   Exercise
   simple function uses PM
    takes an Expr => human readable form
    Sum(Number(2), Number(3)) => 2 + 3
    Sum(Number(2), Number(3), Number(4)) => 2 + 3 + 4
    Prod(Sum(Number(2), Number(1)), Number(3)) = (2 + 1) * 3
    Sum(Prod(Number(2), Number(1)), Number(3)) = 2 * 1 + 3
  */
  trait Expr

  case class Number(n: Int) extends Expr

  case class Sum(e1: Expr, e2: Expr) extends Expr

  case class Prod(e1: Expr, e2: Expr) extends Expr

  def show(expr: Expr): String = expr match {
    case Number(x) => s"${x}"
    case Sum(e1, e2) => s"${show(e1)}  + ${show(e2)}"
    case Prod(e1, e2) => {

      def MaybeShowParantheses(exp: Expr) = {
        exp match {
          case Prod(_, _) => show(exp)
          case Number(_) => show(exp)
          case _ => "(" + show(exp) + ")"
        }
      }

      MaybeShowParantheses(e1) + " * " + MaybeShowParantheses(e2)
    }

  }

  println(show(Sum(Number(20), Number(12))))
  println(show(Prod(Number(20), Number(12))))
  println(show(Prod(Sum(Number(30), Number(20)), Number(12))))
  println(show(Prod(Sum(Number(30), Number(20)), Sum(Number(30), Number(20)))))
  println(show(Sum(Prod(Number(12), Number(13)), Number(15))))

}
