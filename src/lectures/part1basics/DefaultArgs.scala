package lectures.part1basics

import scala.annotation.tailrec

object DefaultArgs extends App {

  //1 1 2 3 5 8
  def fibTailRec(n: BigInt): BigInt = {
    @tailrec
    def fibTailRecHelper(t: BigInt, acc1: BigInt, acc2: BigInt): BigInt = {
      if (t >= n) acc1
      else fibTailRecHelper(t + 1, acc1 + acc2, acc1)
    }

    if (n <= 2) 1
    else fibTailRecHelper(2, 1, 1)
  }

  println("Aakash")
  println(fibTailRec(6))


  @tailrec
  def trFact(x: BigInt, acc: BigInt = 1): BigInt = {
    if (x < 2) acc
    else trFact(x - 1, x * acc)
  }

  val res = trFact(5000)
  println(res)

}
