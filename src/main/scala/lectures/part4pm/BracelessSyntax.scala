package lectures.part4pm

object BracelessSyntax {


  val anIfExpression = if (2 > 3) "Bigger" else "Smaller"

  //compact
  val anIfExpression_v2 = {
    if (2 > 3) "Bigger"
    else "Smaller"
  }
  //Java style
  val anIfExpression_v3 = {
    if (2 > 3) {
      "Bigger"
    }
    else {
      "Smaller"
    }
  }

  //Scala 3
  val anIfExpression_v4 = {
    if 2 > 3 then
      "Bigger"
    else
      "Smaller"
  }
  val anIfExpression_v5 = {
    if 2 > 3 then
      val result = "Bigger"
      result
    else
      "Smaller"
  }

  val anIfExpression_v6 = if 2 > 3 then "Bigger" else "Smaller"

  //for-comprehensions
  val aForComprehensoins = for {
    n <- List(1, 2, 3)
    s <- List("black", "white")
  } yield s"$n $s"

  val aForComprehensoins_v2 =
    for
      n <- List(1, 2, 3)
      s <- List("black", "white")
    yield s"$n $s"


  //Pattern Matching
  val meaningOFLife = 45
  val aPatternMatch = meaningOFLife match {
    case 1 => "The one"
    case 2 => "double or nothing"
    case _ => "something else"
  }

  val allThePatterns_v2 =
    meaningOFLife match
      case 1 => "The one"
      case 2 => "double or nothing"
      case _ => "something else"

  //Methods without braces
  def computeMeaningOfLife(arg: Int): Int =
    val partialResult = 40

    partialResult + 20


  //class definition with significant indentation (same for traits, objects, enums etc)
  class Animal:

    def eat: Unit =
      println("Eating")
    end eat

  end Animal

  val aSpecialAnimal = new Animal :
    override def eat: Unit =
      println("Special")


  def main(args: Array[String]): Unit = {
    println(aForComprehensoins_v2)
  }

}

