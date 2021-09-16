package com.github.valrcs

import java.util.regex.Pattern
import scala.util.matching.Regex

object ExerciseSep16CleanWill extends App {
  val src = "src/resources/The Case of the Missing Will.txt"
  val dst = "src/resources/The Case of the Missing Will_cleaned.txt"

  //TODO read src
  //TODO write to dst the cleaned version without the Project Gutenberg footer
  val lines = Utilities.getLinesFromFile(src)
  val matchText = "THE END"
//  val linesNumberWithMatch = lines.zipWithIndex.filter(lineTuple => lineTuple._1.contains(matchText) )
//  val endingIndex = linesNumberWithMatch.head._2+1
  //above approach would be best if we have multiple matches possibly
  //below approach gets us index of the first match
//  val endingIndex = lines.indexWhere(line => line.contains(matchText)) + 1 //+1 is because Array starts with 0

  //below is classical non Scala way not recommended but still would work
  //this is what the above code would do
//  var endingIndex = 0
//  for ((line, index) <- lines.zipWithIndex) {
//    if (line.contains(matchText)) endingIndex = index + 1
//  }
  //4th even less Scala way, in some languages this is the only way, but Scala above approaches are better
  var endingIndex = 0
  for (index <- 0 until lines.length) {
    if (lines(index).contains(matchText)) endingIndex = index + 1
  }

  val cleanText =lines.slice(0,endingIndex)
  Utilities.saveLines(dst,cleanText)

  //TODO lets extract all lines that contain numbers
  //https://alvinalexander.com/scala/how-find-regex-patterns-matches-in-strings-scala/
//  val numPattern = "[0-9]".r //so this is very loose but still good here
  val numPattern = "^.*[0-9].*$".r //so this is full line definition from start ^ until end $ with some number in middle

  val numLines = lines.filter(line => numPattern.findFirstIn(line).isDefined)
  println(numLines.length)
  numLines.foreach(println)

  //for phone numbers it depends how loose you want to be
  //here are some good examples:
  //https://stackoverflow.com/questions/16699007/regular-expression-to-match-standard-10-digit-phone-number

  val text = lines.mkString("\n") //might be easier
//  val phonePattern = "(\\d\\d\\d) \\d\\d\\d-\\d\\d\\d\\d".r
  val phonePattern = "\\d\\d\\d-\\d\\d\\d\\d".r
  println(phonePattern.findFirstIn(text).getOrElse("Not Found"))

  //if we are tired of escaping \ then we can use Java pattern to escape it

//  val zipCodePattern = Pattern.quote("\w\w \d\d\d\d\d").r
//  val zipCodePattern = "\\w\\w \\d\\d\\d\\d\\d".r //this is too lose we only want capitals it turns out
  val zipCodePattern = "[A-Z][A-Z] \\d\\d\\d\\d\\d".r //this is is stricter we want things like CA 90105
  val zipCodes = zipCodePattern.findAllIn(text).toSeq
  zipCodes.foreach(println)

  //so if we wanted to find lines which contain zip Codes we could use it to filter lines
  val linesWithZipCodes = lines.filter(line => zipCodePattern.findFirstIn(line).isDefined)
  linesWithZipCodes.foreach(println)

  //so for your homework you want to do some filtering first or find some early indexes where to slice

  //worst case scenario you can always hard code some slices, but that should be the last option




}
