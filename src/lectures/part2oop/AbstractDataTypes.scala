package lectures.part2oop

object AbstractDataTypes extends App {

  abstract class Animal {
    val creatureType: String
    def eat : Unit
  }

  class Dog extends Animal {
    override val creatureType: String = "Canine"

    override def eat: Unit = println("Crunch Crunch by "+creatureType)
  }

  var animal = new Dog
  animal.eat

  trait Carnivore {
    def eat(animal: Animal): Unit
  }

  trait ColdBlooded

  class Crocodile extends Animal with Carnivore with ColdBlooded {
    override val creatureType: String = "croc"

    override def eat: Unit = println("nomnomnom "+ creatureType)

    override def eat(animal: Animal): Unit = println(s"I'm a croc and I am eating ${animal.creatureType}")
  }

  var croc = new Crocodile
  croc.eat(animal)
  croc.eat

}
