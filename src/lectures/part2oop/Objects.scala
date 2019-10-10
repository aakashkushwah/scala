package lectures.part2oop

object Objects{

  def main(args: Array[String]): Unit = {
    object Person {
      val N_EYES = 2
      def canFly = false
      def apply(person1: Person) = new Person()
    }

    class Person {

    }

    println(Person.N_EYES)
  }
}
