package lectures.part2oop

object AnonymousClasses extends App{
  abstract class Janitor{
    def clean:Unit
  }

  val funnyJanitor = new Janitor {
    override def clean: Unit = println("Hahaha")
  }

  println(funnyJanitor.getClass)

  class Person(name: String){
    def sayHi: Unit = println(s"Hi my name is $name, how can I help?")
  }

  val personOverridden = new Person("Joker"){

    override def sayHi: Unit = {
      super.sayHi
      println("Doing something more here")
    }
  }

  personOverridden.sayHi
}
