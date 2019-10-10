package com.rtjvm.scala.oop.commands
import com.rtjvm.scala.oop.files.Directory
import com.rtjvm.scala.oop.filesystem.State

class MkDir(name: String) extends Command {
  override def apply(state: State): State = {
    val wd = state.wd
    if(wd.hasEntry(name)){
      state.setMessage("Entry "+name+" already exists!")
    } else if(name.contains(Directory.SEPARATOR)){
      state.setMessage(name+" must not contain separators")
    }else if(checkIllegal(name)){
      state.setMessage(name+": illegal entry name!")
    } else {
      doMkdir(state, name)
    }
  }

  def checkIllegal(str: String):Boolean = {
    name.contains(".")
  }

  def doMkdir(state: State, name: String):State ={
    val wd = state.wd
    val fullPath = wd.path
    //1. all the directories in full path

    //2. update the new structure , create new directory entry in wd

    //3. update the whole directory structure from the root
    //(the directory structure is immutable)

    //4. find new working directory instance given wd full path in the new directory structure

  }
}
