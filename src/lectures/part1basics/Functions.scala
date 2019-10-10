package lectures.part1basics

import scala.annotation.tailrec

object Functions extends App {

  def aRepeatedFunc(aString: String, n: Int): String = {
    if(n == 1) aString
    else aString + aRepeatedFunc(aString, n-1)
  }

  println(aRepeatedFunc("hello", 3))

  def factorial(n: Int): Int = {
    if(n <= 1) 1
    else n* factorial(n-1)
  }

  def factorial2(n: Int): Int = {
    if(n <= 1) 1
    else {
      var res = n* factorial(n-1)
      res
    }
  }

  def anotherFactorial (n: BigInt): BigInt = {
    @tailrec
    def factHelper(x: BigInt, acc: BigInt): BigInt = {
      if(x<2) acc
      else factHelper(x-1, x* acc)
    }
    factHelper(n, 1)
  }

  def fibbonaci(n: Int): Int = {
    if(n<=2) 1
    else fibbonaci(n-1) + fibbonaci(n-2)
  }

  def isPrime(n: Int): Boolean = {
    def isDivisible(b: Int): Boolean = {
      if(b<=1) true
      else n%b != 0 && isDivisible(b-1)
    }
    isDivisible(n/2)
  }

//  println(anotherFactorial(50000))
//  println(factorial2(50000))
  println(fibbonaci(5))
  println(isPrime(37))


  //WHEN you need Loops use Recursion

  def aFunction(a: String, n: Int) = {
    a+" "+n
  }

  println(aFunction("Hello", 4))

  def aFuncWithSideEffects (aString: String): Unit = {
    println(aString)
  }

  def aFuncWithSideEffects2 (aString: String) = println(aString)

  def aBigFunc(n: Int): Int = {
    def aSmallFunc(a: Int, b: Int): Int = a+b
    aSmallFunc(n,n-1)
  }

  println(aBigFunc(5))

  //1 1 2 3 5 8
  def fibTailRec(n : BigInt): BigInt = {
    def fibTailRecHelper(t: BigInt, acc1: BigInt, acc2: BigInt): BigInt = {
      if(t >= n) acc1
      else fibTailRecHelper(t+1, acc1+acc2, acc1)
    }
    if(n <= 2) 1
    else fibTailRecHelper(2, 1, 1)
  }
  println("Aakash")
  println(fibTailRec(6))

  def isPrimeTailRec(n: Int): Boolean = {
    @tailrec
    def isPrimeTailRecHelper(t: Int, isStillPrime: Boolean) : Boolean = {
      if(!isStillPrime) false
      else if(t <=1) true
      else isPrimeTailRecHelper(t-1, n%t!=0 && isStillPrime)
    }
    isPrimeTailRecHelper(n/2, true)
  }

  println(isPrimeTailRec(37))

  @tailrec
  def concatenant(str: String, n: Int, acc: String): String = {
    if(n<=0) acc
    else concatenant(str, n-1, str+acc)
  }

  println(concatenant("aakash", 10, ""))


}
