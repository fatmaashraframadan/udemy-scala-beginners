package lectures.part3fp

object AnonymousFunctions extends App {
  val doubler: Int => Int = (a: Int) => a * 2

  val adder: (Int, Int) => Int = (a: Int, b: Int) => a + b

  println(adder(4, 5))

  val doSomething: () => Int = () => 3

  println(doSomething)
  println(doSomething())

  val stringToInt = {
    (x: String) =>
      x.toInt + 20
  }

  println(stringToInt("5"))

  /*
   1.  MyList: replace all FunctionX calls with lambdas
   2.  Rewrite the "special" adder as an anonymous function
  */

  val supperAdder = (b: Int) => (x: Int) => {
    println(x+"  "+b)
    x + b
  }
  val adder3 = supperAdder(5)
  println(adder3(3))
  println(supperAdder(20)(40))

}
