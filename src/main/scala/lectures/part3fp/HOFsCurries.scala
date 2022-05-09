package lectures.part3fp

object HOFsCurries extends App {
  def nTimes(f: Int => Int, n: Int, x: Int): Int = {
    if (n <= 0) x
    else nTimes(f, n - 1, f(x))
  }

  val inc = (x: Int) => x + 1

  println(nTimes(inc, 2, 1))

  def curriedFromatter(c: String)(x: Double): String = c.format(x)

  val standardFormat = curriedFromatter("%4.2f")(20.0)
  val preciseFormat: (Double => String) = curriedFromatter("%10.16f")

  print(standardFormat)
  //  println(standardFormat(Math.PI))
  //  println(preciseFormat(Math.PI))

  /*
    1.  Expand MyList
        - foreach method A => Unit
          [1,2,3].foreach(x => println(x))
        - sort function ((A, A) => Int) => MyList
          [1,2,3].sort((x, y) => y - x) => [3,2,1]
        - zipWith (list, (A, A) => B) => MyList[B]
          [1,2,3].zipWith([4,5,6], x * y) => [1 * 4, 2 * 5, 3 * 6] = [4,10,18]
        - fold(start)(function) => a value
          [1,2,3].fold(0)(x + y) = 6
    2.  toCurry(f: (Int, Int) => Int) => (Int => Int => Int)
        fromCurry(f: (Int => Int => Int)) => (Int, Int) => Int
    3.  compose(f,g) => x => f(g(x))
        andThen(f,g) => x => g(f(x))
   */

  def toCurry(f: (Int, Int) => Int): Int => Int => Int = {
    x => y => f(x, y)
  }

  def fromCurry(f: Int => Int => Int): (Int, Int) => Int = {
    (x, y) => f(x)(y)
  }

  def compose(f: Int => Int, g: Int => Int): Int => Int = {
    x => f(g(x))
  }

  def andThen(f: Int => Int, g: Int => Int): Int => Int = {
    x => g(f(x))
  }

  def superAdder2: (Int => Int => Int) = toCurry(_ + _)

  def add4 = superAdder2(4)

  println(add4(17))


  val add2 = (x: Int) => x + 2
  val times3 = (x: Int) => x * 3

  val composed = compose(add2, times3)
  val ordered = andThen(add2, times3)

  println(composed(4))
  println(ordered(4))
}
