package lectures.part1basics

object StringOps extends App{

  val str = "Hello, I am learning Scala"
  println(str.charAt(2))
  println(str.split(" ").toList)

  val ns = "45"
  val nn = ns.toInt
  println('a'+: ns:+'b')
  println('b'+ ns + 'a')
  println(str.take(2))

  val greeting=s"my name is $ns and my age is ${nn+1}"

  println(greeting)

  val name = "Jake"
  val sp = 1.2f
  val myth = f"$name%s can eat with speed of $sp%2.2f burgers per minute"
  println(myth)
  println("This is a \n new line")
  println(raw"This is a \n new line")

}
