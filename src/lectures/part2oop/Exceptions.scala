package lectures.part2oop

object Exceptions extends App{

  val x: String = null
//  println(x.length)
//  val aWeirdVal = throw new NullPointerException
//  println(aWeirdVal)

  def getInt(withException : Boolean) :Int = {
    if(withException) throw new RuntimeException("No Int for you!")
    else 42
  }

  val potFail = try {
    getInt(true)
  } catch {
//    case e: RuntimeException => println("Caught runtime Exception")
    case e: RuntimeException => 43
  } finally {
    println("bye!")
  }

  println(potFail)

  class OverFlowExceptione extends RuntimeException
  class UnderflowException extends RuntimeException
  class MathCalcExceptione extends RuntimeException

  object PocketCalculator {
    def add(x:Int, y:Int) = {
      val res = x+y
      if(x>0 && y>0 && res <0) throw new OverFlowExceptione
      else if(x<0 && y<0 && res>0) throw new UnderflowException
      else res
    }

    def subtract(x:Int, y:Int) = {
      val res = x-y
      if(x>0 && y<0 && res <0) throw new OverFlowExceptione
      else if(x<0 && y>0 && res >0) throw new UnderflowException
      else res
    }

    def multiply(x:Int, y:Int) = {
      val res = x*y
      if(x>0 && y>0 && res <0) throw new OverFlowExceptione
      else if(x<0 && y<0 && res<0) throw new OverFlowExceptione
      else if(x>0 && y<0 && res>0) throw new UnderflowException
      else if(x<0 && y>0 && res>0) throw new UnderflowException
      else res
    }

    def divide(x:Int, y:Int) ={
      if(y == 0) throw new MathCalcExceptione
      else x/y
    }
  }

//  println(PocketCalculator.add(Int.MaxValue, 10))
  println(PocketCalculator.divide(2,0))
}
