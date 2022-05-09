package lectures.part2oop

import jdk.jshell.spi.ExecutionControlProvider

object Exceptions extends App {
  //val aWeirdValue = throw new NullPointerException()

  //println(aWeirdValue)

  def getInt(withException: Boolean): Int =
    if (withException) throw new RuntimeException("No int for you")
    else 42


  val potentialFail = try {
    getInt(false)
  } catch {
    case e: RuntimeException => 43
  } finally {
    println("Finally")
  }
  println(potentialFail)

  /*
  1.  Crash your program with an OutOfMemoryError
  2.  Crash with SOError
  3.  PocketCalculator
      - add(x,y)
      - subtract(x,y)
      - multiply(x,y)
      - divide(x,y)
      Throw
        - OverflowException if add(x,y) exceeds Int.MAX_VALUE
        - UnderflowException if subtract(x,y) exceeds Int.MIN_VALUE
        - MathCalculationException for division by 0
 */

  //println(testVal)

  class OverFlowException extends Exception

  class UnderFlowException extends Exception

  class MAthCalculationException extends Exception

  object PocketCalculator {
    def add(x: Int, y: Int): Int = {
      val result = x + y
      if (result < 0 && (x > 0) && (y > 0)) {
        throw new OverFlowException
      } else if (x < 0 && y < 0) throw new UnderFlowException
      else result
    }

    def subtract(x: Int, y: Int): Int = {
      val result = x - y
      if (result < 0 && (x > 0) && (y < 0)) {
        throw new OverFlowException
      } else if (x < 0 && y > 0 && result > 0) throw new UnderFlowException
      else result
    }

    def multiply(x: Int, y: Int): Int = { //
      val result = x * y
      if (result < 0 && (((x > 0) && (y > 0)) || (x < 0 && y < 0))) {
        throw new OverFlowException
      } else if (((x < 0 && y > 0) || ((x > 0 && y < 0))) && result > 0) throw new UnderFlowException
      else result
    }

    def divide(x: Int, y: Int): Int = {
      val result = x / y
      if (y == 0) throw new MAthCalculationException
      else result
    }
  }

  println(PocketCalculator.divide(2, 0)) //This will crach the program with divide/0 exception
}
