package lectures.part3fp

object WhatsAFunction extends App {
  val doubler = new MyFunction[Int, Int] {
    override def apply(element: Int): Int = element * 2
  }

  println(doubler(2))

  val stringToIntConverter = new Function[String, Int] {
    override def apply(string: String): Int = string.toInt
  }

  println((stringToIntConverter("3") + 4))

  val adder = new Function2[Int, Int, Int] {
    override def apply(a: Int, b: Int): Int = a + b
  }

  /*
     1.  a function which takes 2 strings and concatenates them
     2.  transform the MyPredicate and MyTransformer into function types
     3.  define a function which takes an int and returns another function which takes an int and returns an int
         - what's the type of this function
         - how to do it
    */


  val concatenator = new Function2[String, String, String] {
    override def apply(str1: String, str2: String): String = str1 + str2
  }
  println(fun1(22))

  val supperAdder = new Function1[Int, Function1[Int, Int]] {
    override def apply(b: Int): Function1[Int, Int] = new Function1[Int, Int] {
      override def apply(a: Int): Int = {
        println(a + "  " + b)
        a + b
      }
    }
  }

  val adder3 = supperAdder(5)
  println(adder3(3))
  println(supperAdder(20)(40))
}

def fun2(a: Int): Int = a + 3
def fun1(a: Int): Int = {
  fun2(a)
}

trait MyFunction[A, B] {
  def apply(element: A): B
}
