package lectures.part2oop

object OOBasics extends App {
  val person = new Person("aakash", 32)
  println(person.age)
  println(person.x)
  person.greet("Daniel")
  person.greet()

  val p1 = new Person()
  println(p1.age)
  p1.greet()
  p1.greet("YoYo")

  val wr = new Writer("aakash", "Kushwah", 1987)
  println(wr.fullName())

  val novel = new Novel("Great Expectation", 2010, wr);
  val imposter = new Writer("aakash", "Kushwah", 1987)

  println(novel.authorAge)
  println(novel.isWrittenBy(wr))
  println(novel.isWrittenBy(imposter))

  val counter = new Counter
  counter.inc.print;
  counter.inc.inc.inc.print
  counter.inc(5).print

}

class Person (name: String="Joker", val age: Int = 0) {
  def this(name: String) = this(name, 0)
//  def this() = this("Kushwah")
  val x =2;
  println(1+3)

  def greet(name: String) = println(s"${this.name} says hi, $name")
  def greet() = println(s"hi $name")
}

//CLASS PARAMETERS are not FIELDS and cannot be accessed via . e.g. person.name

class Writer (fname: String, sname: String, val year :Int) {

  def fullName() = s"$fname $sname"
}

class Novel(name: String, relYear: Int, author: Writer){
  def authorAge = relYear - author.year
  def isWrittenBy (author : Writer) : Boolean = author == this.author
  def copy(year: Int): Novel = new Novel(name, year, author)
}

class Counter(val count: Int = 0) {
  def inc = {
    println("Incrementing")
    new Counter(count+1)
  } //immutability
  def dec = {
    println("Decrementing")
    new Counter(count-1)
  }

//  def inc(n: Int) = new Counter(count+n)
//  def dec(n: Int) = new Counter(count-n)

  def inc(n: Int): Counter = {
    if(n<=0) this
    else inc.inc(n-1)
  }

  def dec(n: Int): Counter = {
    if(n<=0) this
    else dec.dec(n-1)
  }

  def print = println(count)

}