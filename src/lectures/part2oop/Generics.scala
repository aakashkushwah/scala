package lectures.part2oop

object Generics extends App {
  class MyList[+A] {
    def add[B >: A](element: B): MyList[B] = ???
  }

  class MyMap[Key, Value]

  val listOfStrings = new MyList[String]
  val listOfInts = new MyList[Int]

  object MyList{
    def empty[A]: MyList[A] = ???
  }

  val myLustOfInts = MyList.empty[Int]

  //variance
  class Animal
  class Cat extends Animal
  class Dog extends Animal

  //yes List of cat extends List of Animals = CoVariance
  class CovariantList[+A] extends MyList
  val animal: Animal = new Cat
  val animalList: CovariantList[Cat] = new CovariantList[Cat]
  //animalList.add(new Dog) ??? Hard Question
  animalList.add(new Dog)

  //No invariant list
  class InvariantList[A]
  val inVariantAnimalList: InvariantList[Animal] = new InvariantList[Animal]

  //Hell No !Contra Variant
  class ContraVariantList[-A]
  val contraVariantList: ContraVariantList[Cat] = new ContraVariantList[Animal]

  //bounded types
  class Cage[A <: Animal](animal :A) {

  }

//  val cage = new Cage(new Dog)
//  class Car
//  val newCage = new Cage(new Car)

}
