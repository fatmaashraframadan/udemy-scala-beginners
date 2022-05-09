package lectures.part2oop

object OOBasics extends App {
  val author = new Writer("xyz", "xxx", 1812)

  val novel = new Novel("test2 ", 1861, author)

  println(novel.getAuthorAge)
  println(novel.isWrittenBy(author))
}

class Writer(val firstName: String, val surName: String, val age: Int) {
  def getFullName: String = this.firstName + this.surName

}

class Novel(val name: String, val releaseYear: Int, val author: Writer) {
  def getAuthorAge: Int = {
    this.releaseYear - this.author.age
  }

  def isWrittenBy(author2:Writer): Boolean = {
    this.author == author2
  }

  def copy(newReleaseYear: Int): Novel = {
    val x = new Novel(this.name, newReleaseYear, this.author)
    x
  }
}

class counter(val c: Int) {
  def currentCount(): Int = {
    this.c
  }

  def Increment(): counter = {
    new counter(c+1)
  }

  def Decrement(): counter = {
    new counter(c-1)
  }

  def Increment(x: Int): counter = {
    if(x <= 0)this
    else Increment().Increment(x-1)
  }

  def Decrement(x: Int): Int = {
    val newC = this.c - x
    newC
  }
}
