package lectures.part2oop

object AbstractDataTypes extends App {
  abstract class Animal {
    val x: String
    val x2 = 5

    def eat: Unit
  }

  class Cat extends Animal {
    override val x: String = "ddd"

    override def eat: Unit = {
      println("hello")
    }
  }
}
