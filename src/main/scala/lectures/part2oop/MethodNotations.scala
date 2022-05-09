package lectures.part2oop

import scala.language.postfixOps

object MethodNotations extends App {

  class Person(val name: String, val age: Int = 0) {

    def +(str: String): Person = {
      new Person(s"${str} (${this.name})", age)
    }

    def unary_+ : Person = {
      val xx = this.age + 1
      println("test  : " + xx)
      new Person(name, xx)
    }

    def learns: String = {
      s"${this.name} learns Scala"
    }

    def apply(x:Int): String = {
      s"${this.name} watched the film ${x} times"
    }

  }

  val fatma = new Person("Fatma")

  println((fatma + "hello") (2))
  println(fatma.+("Helloo").name + "    " + fatma.age)
  println((+fatma).age)

  //println(fatma(5))
}
