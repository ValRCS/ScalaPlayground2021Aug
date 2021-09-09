package com.github.valrcs

import com.github.valrcs.Utilities.getLinesFromFile
//I can already use Utilities but I also have the short version from above


object ReadingFiles extends App {
  println("Going to read some file")

  //let's check our current working directory because we need to know to have correct relative path

  println(System.getProperty("user.dir"))

  //there are absolute locations specific to your computer like C:/mydirectory/myfile.txt
  //there are relative locations relative to some reference point, like your current location
  //or location of your project folder
  //relative locations are more flexible when moving across computers
  val filePath = "src/resources/two_roads.txt" //to get this path
  // we started at location indicated by println(System.getProperty("user.dir"))



//  val lines = Utilities.getLinesFromFile(filePath) //since i am lazy i could import it
  val lines = getLinesFromFile(filePath)
  println(s"Cool we got a poem with ${lines.length} lines")
  println(lines.mkString("\n")) //so we put back the newline...

  //we can always get back the text file with the new lines
  val text = lines.mkString("\n") //so we get back the newlines
  print(text)
}
