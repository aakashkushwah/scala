package lectures.part2oop

object Inheritence extends App {

  class Person(name: String, age: Int){
    def this(name: String) = this(name, 0)
  }
  class AdultA(name: String, age:Int, idCard: String) extends Person(name, age)
  class AdultB(name: String, age:Int, idCard: String) extends Person(name)

  sealed class Animal {
    val creatureType = "wild"
    def eat = println("nomnom "+ this.creatureType)
  }

  class Dog(override val creatureType: String) extends Animal {
//    override val creatureType: String = "Wild Dogs"
    override def eat = {
      super.eat
      println("crunch crunch "+this.creatureType)
    }
  }

  class Cat extends Animal {
    def crunch = {
      eat
      println("Cat Crunch, Crunch")
    }
  }

  val dog = new Dog("Wild Dog")
  dog.eat

  val cat = new Cat
  cat.crunch

  val animal = new Dog("doggie")
  animal.eat
}
