package lectures.part1basics

import scala.annotation.tailrec

object Recursion extends App {

  def factorial(n: Int): Int =
    if (n <= 1) 1
    else {
      println("Computing factorial of " + n + " - I first need factorial of " + (n - 1))
      val result = n * factorial(n - 1)
      println("Computed factorial of " + n)

      result
    }

  println(factorial(10))
  //  println(factorial(5000)) // stack overflow!

  def anotherFactorial(n: Int): BigInt = {
    @tailrec
    def factHelper(x: Int, accumulator: BigInt): BigInt =
      if (x <= 1) accumulator
      else factHelper(x - 1, x * accumulator) // TAIL RECURSION = use recursive call as the LAST expression

    factHelper(n, 1)
  }


  /*
  Exercises:
  1.  Concatenate a string n times
  2.  IsPrime function tail recursive
  3.  Fibonacci function, tail recursive.
 */

  //String Concatenation function
  def Concatenate(aString: String, n: Int, aStr: String): String = {
    if (n <= 0) aStr
    else Concatenate(aString, n - 1, aStr + aString)
  }

  println(Concatenate("Fatma", 5, ""))

  // isPrime Tail recursion
  def isPrimeTail(n: Int, i: Int, res: Boolean): Boolean = {
    if (i >= n / 2) res
    else isPrimeTail(n, i + 1, (res & (n % i != 0)))
  }

  println(isPrimeTail(2003, 2, true))

  def isPrime(n: Int): Boolean = {
    def isPrimeTailrec(t: Int, isStillPrime: Boolean): Boolean =
      if (!isStillPrime) false
      else if (t <= 1) true
      else isPrimeTailrec(t - 1, n % t != 0 && isStillPrime)

    isPrimeTailrec(n / 2, true)
  }

  println(isPrime(2003))
  println(isPrime(629))

  //Fibbonacci
  def Fibbonacci(n: Int): Int = {
    def FibbonacciTail(i: Int, last: Int, nextToLast: Int): Int = {
      if (i >= n) last
      else FibbonacciTail(i + 1, last + nextToLast, last)
    }

    if (n <= 2) 1
    else FibbonacciTail(2, 1, 1)
  }


  println(Fibbonacci(8))
}
