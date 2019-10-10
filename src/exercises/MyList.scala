package exercises

import lectures.part2oop.Generics.MyList

abstract class MyList[+A] {
  def head: A;

  def tail: MyList[A]

  def isEmpty: Boolean

  def add[B >: A](n: B): MyList[B]

  def printElements: String

  override def toString: String = "[" + printElements + "]"

  def map[B](transformer: MyTransformer[A,B]): MyList[B]

  def flatMap[B](transformer: MyTransformer[A, MyList[B]]): MyList[B]

  def filter(predicate: MyPredicate[A]) : MyList[A]

  def ++[B >: A](list: MyList[B]): MyList[B]
}

trait MyPredicate[-T] {
  def test(t: T): Boolean
}

trait MyTransformer[-A, B] {
  def transform(a: A): B
}

case object Empty extends MyList {
  override def head: Nothing = throw new NoSuchElementException

  override def tail: MyList[Nothing] = throw new NoSuchElementException

  override def isEmpty: Boolean = true

  override def add[B >: Nothing](n: B): MyList[B] = new Cons(n, Empty)

  override def printElements: String = ""

  override def map[B](transformer: MyTransformer[Nothing, B]): MyList[B] = Empty

  override def flatMap[B](transformer: MyTransformer[Nothing, MyList[B]]): MyList[B] = Empty

  override def filter(predicate: MyPredicate[Nothing]): MyList[Nothing] = Empty

  override def ++[B >: Nothing](list: MyList[B]): MyList[B] = list
}

case class Cons[+A](h: A, t: MyList[A]) extends MyList[A] {
  override def head: A = h

  override def tail: MyList[A] = t

  override def isEmpty: Boolean = false

  override def add[B >: A](n: B): MyList[B] = new Cons(n, this)

  override def printElements: String = {
    if (t.isEmpty) "" + head
    else h + " " + t.printElements
  }

  override def map[B](transformer: MyTransformer[A, B]): MyList[B] = {
    new Cons(transformer.transform(h), t.map(transformer))
  }

  override def flatMap[B](transformer: MyTransformer[A, MyList[B]]): MyList[B] = transformer.transform(h) ++ t.flatMap(transformer)

  override def filter(predicate: MyPredicate[A]): MyList[A] = {
    if(predicate.test(h))
      new Cons(h, t.filter(predicate))
    else t.filter(predicate)
  }

  override def ++[B >: A](list: MyList[B]): MyList[B] = new Cons(h, t ++ list)
}

object ListTest extends App {
  //  val list = new Cons(1, new Cons(2, new Cons(3, Empty)))
  //  println(list.head)
  //  println(list.tail.head)
  //  println(list.add(4).head)
  //  println(list.isEmpty)
  //  println(list.toString)

  val listOfInts: MyList[Int] = new Cons[Int](1, new Cons[Int](2, new Cons[Int](3, Empty)))
  println(listOfInts.toString)
  //  val listOfStrings = MyList[String] = Empty
  println(listOfInts.map(new MyTransformer[Int, Int] {
    override def transform(a: Int): Int = a*2
  }))

  val filteredList = listOfInts.filter(new MyPredicate[Int] {
    override def test(t: Int): Boolean = t%2 == 0
  })
  println(filteredList.toString)

  println(listOfInts.flatMap(new MyTransformer[Int, MyList[Int]] {
    override def transform(a: Int): MyList[Int] = new Cons(a, new Cons(a+1, Empty))
  }).toString)

  println(listOfInts ++ filteredList)

  val clonedList: MyList[Int] = new Cons[Int](1, new Cons[Int](2, new Cons[Int](3, Empty)))
  println(clonedList == listOfInts)
}