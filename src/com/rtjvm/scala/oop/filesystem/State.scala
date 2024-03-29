package com.rtjvm.scala.oop.filesystem

import com.rtjvm.scala.oop.files.Directory

class State(val root: Directory, val wd: Directory, val output: String) {
  def show = {
    println(output)
    print(State.SHELL_TOKEN)
  }
  def setMessage(msg: String): State = State(root, wd, msg)

}
object State {
  val SHELL_TOKEN = "$ "
  def apply(root: Directory, wd:Directory, output:String = ""): State = new State(root, wd, output)
}