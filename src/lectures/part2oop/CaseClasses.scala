package lectures.part2oop

object CaseClasses extends App {
  case class Person(name: String, age:Int){

  }
  //class parameters are promoted to fields
  //
  val jim = new Person("Jim", 21)
  println(jim.age)

  //sensible to string
  println(jim.toString)
  println(jim)

  //equals and hashcode are already implemented out of the box

  var person2 = new Person("Jim", 21)
  println(jim == person2)

  var jim2 = jim.copy(age = 34)
  println(jim2)

  val thePerson = Person
  val mary = Person("Mary", 32)
  println(mary)

  case object UnitedKingdom {
    def name : String = "The UK of GB and NI"
  }
}
