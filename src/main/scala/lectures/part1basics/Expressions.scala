package lectures.part1basics

object Expressions extends App{
  var x = 1
  println(x)

  var x2 = 20
  println(x2%3)


  val someValue = {
    2 < 3
  }

  println(someValue)

  val someOtherVal = {
    if(someValue)1000 else 2000
    55
  }

  println(someOtherVal)

}
