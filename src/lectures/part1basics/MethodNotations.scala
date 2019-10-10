package lectures.part1basics
import scala.language.postfixOps

object MethodNotations extends App{

  class Person(val name: String, favMovie: String, age: Int = 0){
    def likes(movie: String): Boolean = movie == favMovie
    def +(person: Person) : String = s"${this.name} is hanging out with ${person.name}"
    def unary_! : String = s"$name, what the heck"
    def isAlive: Boolean = true
    def apply(): String = s"Hi! my name is $name. I like $favMovie with age as $age"
    def + (str: String) = new Person(s"$name $str", favMovie)
    def unary_+ = new Person(name, favMovie, age+1)
    def learns (str: String) = s"$name is learning $str"
    def apply(i: Int) = s"$name watched the movie $favMovie $i times"
    def learnsScala = this.learns("Scala")
  }

  val mary = new Person("Mary", "Inception")
  println(mary.likes("Inception"))
  println(mary likes "Inception") //Infix notation, Operator Notation only if there is a single parameter
  //example of syntactic sugar
  println((mary+" the rockstar")())
  println((+mary)())
  println((+mary)(3))
  println(mary learnsScala)
  //"Operators" in scala
  val tom = new Person("Tom", "Fight Club")
//  println(mary + tom)
//  println(mary.+(tom))
  println(1.+(2))
  //All operators are methods

  //prefix notations
  val x = -1
  val y = 1.unary_+
  //unary_ prefix only works with -,+,~ !

  println(!mary)

  //postfix notation
  println(mary.isAlive)
  println(mary isAlive)

  println(mary.apply())
  println(mary())
}
