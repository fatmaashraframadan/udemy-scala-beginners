package lectures.part1basics

object Functions extends App {
  def func(str: String, n: Int): String = {
    if (n == 1) str
    else str + func(str, n - 1)
  }

  println(func("fatma", 3))


  // Task.1
  def greeting(aString: String, n: Int): String = {
    "Hi, My name is " + aString + " and i'm " + n + " years old. "
  }

  println(greeting("fatmaa", 22))


  //Factorial
  def Factoorial(n: Int): Int = {
    if (n == 0) 1
    else n * Factoorial(n - 1)
  }

  println(Factoorial(3))
  println(Factoorial(5))
  println(Factoorial(6))

  //Fibonacci
  def Fibonacci(n: Int): Int = {
    if (n == 0) 0
    else if (n == 1) 1
    else Fibonacci(n - 1) + Fibonacci(n - 2)
  }

  //  println(Fibonacci(1))
  //  println(Fibonacci(2))
  //  println(Fibonacci(3))
  //  println(Fibonacci(5))
  //  println(Fibonacci(7))

  //test if number print
  def isPrime(n: Int): Boolean = {
    //  println(i)
    def isPrimeUtil(i: Int): Boolean =
      if (i < 2) true
      else n % i != 0 && isPrimeUtil(i - 1)

    isPrimeUtil(n / 2)
  }

  println(isPrime(37))
  println(isPrime(2003))
  println(isPrime(37 * 17))

}
