package lectures.part2oop

object Generics extends App {
  class MyList[A] { //Now pass any datatype

  }

  class MyMap[key, value] { // Pass any 2 data stypes.

  }


  object MyList {
    def empty[A]: MyList[A] = ???
  }


  val listOfIntegers = new MyList[Int]
  val listOfStrings = new MyList[String]

  class Animal

  class Cat extends Animal

  class Dog extends Animal


  //Covariant
  class Covariant[+A]

  val covariant: Covariant[Animal] = new Covariant[Cat]

  //InVariant
  class Invariant[A]

  val invariant: Invariant[Animal] = new Invariant[Animal]

  //Contravariat
  class Trainer[-A]

  val trainer: Trainer[Cat] = new Trainer[Animal]


  //bounded type
  class Cage[A >: Animal](animal: Animal)

  val cage = new Cage(new Animal)

  class Car
 // val newCage = new Cage(new )

}
