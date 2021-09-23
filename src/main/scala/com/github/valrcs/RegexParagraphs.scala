package com.github.valrcs

object RegexParagraphs extends App {
  val srcFile = "src/resources/61262-0.txt"
  val text = Utilities.getTextFromFile(srcFile)
  println(text.size)
//  val paragraphs = text.split("\\r\\n\\r\\n") //we define paragraph as 2 newlines
  val paragraphs = text.split("(\\r\\n){2,}") //we define paragraph as 2 or more newlines
  //unfortunately newlines in windows are really two characters - carriage return and line feed
  //it should not be an issue on linux or mac
  println(paragraphs.size)

//  println(text.slice(0,100))
//  text.slice(0,100).foreach(c => println(c, c.toInt))
}
