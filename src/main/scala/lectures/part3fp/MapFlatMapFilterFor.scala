package lectures.part3fp

object MapFlatMapFilterFor extends App {
  //List
  val list = List(1, 2, 3)

  println(list)
  println(list.head)
  println(list.tail)

  //Map
  println(list.map(_ + 1))
  println(list.map(_ + " is a member"))

  //Filter
  println(list.filter(_ % 2 == 0))

  //FlatMap
  val toPair = (x: Int) => List(x, x + 1)
  println(list.flatMap(toPair))


  val numbers = List(1, 2, 3, 4)
  val chars = List('a', 'b', 'c', 'd', 'e')
  val colors = List("Red", "Blue", "Green")

  val combinations = numbers.flatMap(n => colors.flatMap(color => chars.map(c => "" + c + n + " - " + color)))
  println(combinations)

  //for-comprehension
  val forcomprehension = for {
    n <- numbers
    c <- chars
    color <- colors
  } yield "" + c + n + " - " + color

  println(forcomprehension)

  numbers.foreach(println)
  for {
    n <- numbers
  } println(n)

  val vv = numbers.map {
    x => x * 2
  }
  println(vv)

  var v = for {
    n <- numbers
  } yield n * 2
  println(v)

  /*
  1.  MyList supports for comprehensions?
      map(f: A => B) => MyList[B]
      filter(p: A => Boolean) => MyList[A]
      flatMap(f: A => MyList[B]) => MyList[B]
  2.  A small collection of at most ONE element - Maybe[+T]
      - map, flatMap, filter
 */
}

