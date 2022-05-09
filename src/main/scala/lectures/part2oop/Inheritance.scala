package lectures.part2oop

object Inheritance extends App {
  class Animal {
    val v1 = "Hello"
  }

  class Cat(override val v1: String) extends Animal {
    //override val v1 = "Hellooo2"
  }

  val animal = new Animal
  val cat = new Cat("tessst")

  println(animal.v1)
  println(cat.v1)
}
