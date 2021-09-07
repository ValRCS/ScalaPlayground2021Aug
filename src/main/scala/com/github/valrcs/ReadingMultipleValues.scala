package com.github.valrcs

import scala.io.StdIn.readLine

object ReadingMultipleValues extends App {
  val userInput = readLine("Enter Your first name age and eye color separated by single space ")
  //we would usually use this with strange user input coming from elsewhere

  //we return a tuple of 3 values
  def parseUserInput(userInput: String): (String, Int, String) = {
    val trimmedInput = userInput.replaceAll(" +", " ") //so we replace one or more whitespace with single
    trimmedInput match {
      case s"$name $age $eyeColor" => {
        println(name, age, eyeColor) //for debugging
        val ageFixed = if (age.length == 0) 0 else age.toInt //kind of hacky so regex is probably indicated for harder cases
        (name, ageFixed, eyeColor) //this is our return
      }

      case _ => ("noName", 0, "unknown")
    }
//    ("Valdis", 46, "brown") //FIXME
  }

  //I unpack the tuple immediately since I do not like using tuples
  val (name, age, eyeColor) = parseUserInput(userInput)
  println(s"Cool name $name, you are $age old and your eyes are $eyeColor")

  //alternative is more wordy
  val myTuple = parseUserInput(userInput)
  val nameToo = myTuple._1 //i prefer to avoid using tuples directly
  //etc
}
