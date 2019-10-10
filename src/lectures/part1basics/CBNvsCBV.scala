package lectures.part1basics

object CBNvsCBV extends App {
  def callByValue(x: Long): Unit = {
    println("by Value "+x)
    println("by Value "+x)
  }

  def callByName(x: => Long): Unit = {
    println("by Value "+x)
    println("by Value "+x)
  }

  println(callByValue(System.nanoTime()))
  println(callByName(System.nanoTime()))
}
