package lectures.part3fp

import scala.util.Random

object Sequences extends App {
  val aSequence = Seq(1, 3, 5, 2)

  println(aSequence)
  println(aSequence(2))
  println(aSequence(0))
  val x = aSequence.sorted
  println(x)
  println(aSequence)
  println(aSequence.reverse)
  println((aSequence ++ Seq("a", "bb", 5)))

  //Range
  val aRange = 1 until 10

  aRange.foreach(x => print(x * 2 + "  "))
  print("\n")

  //Lists
  val aList = List(1, 2, "a", 4)
  println(aList)
  println(aList.mkString(" - "))
  println(aList.reverse)

  val Prepend = 24 +: aList :+ 98
  println(Prepend)

  val list2 = List.fill(10)(15)
  println(list2)

  //Arrays
  val arr = Array(1, 2, 23, 4)
  arr.foreach(println)

  val ThreeElements = Array.ofDim[Int](5)
  println(ThreeElements.mkString(" "))

  //Mutation
  ThreeElements(2) = 24
  ThreeElements.foreach(x => print(x + " "))

  val numberSeq: Seq[Int] = arr
  println(arr)


  //Vector
  val vector = Vector(1, 2, 3, 4)
  println(vector)

  //Vector vs Lists

  val maxRuns = 1000
  val maxCapacity = 1000000

  def getWriteTime(collections: Seq[Int]): Double = {
    val index = Random()

    val times = for {
      it <- 1 to maxRuns
    } yield {
      val currentTime = System.nanoTime()
      collections.updated(index.nextInt(maxCapacity), index.nextInt())

      System.nanoTime() - currentTime
    }

    times.sum * 0.1 / maxRuns
  }

  val numbersList = (1 to maxCapacity).toList
  val numbersVector = (1 to maxCapacity).toVector

  println(getWriteTime(numbersList))
  println(getWriteTime(numbersVector))

}
