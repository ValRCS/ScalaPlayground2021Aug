package com.github.valrcs

object ExerciseSep14ExtractStories extends App {
  val srcPath = "src/resources/61262-0.txt"
  val lines = Utilities.getLinesFromFile(srcPath)
  println(s"There are ${lines.length} lines in $srcPath")

  //TODO get some stats about the file
  //TODO get character count across all lines - so how many symbols are in the file total
  //TODO get word count (words here would mean words separated by one or more spaces this would include I and numbers

  val matchText = "CONTENTS"
  val linesNumberWithMatch = lines.zipWithIndex.filter(lineTuple => lineTuple._1.contains(matchText) )
  println(linesNumberWithMatch.head)
  val startingIndex = linesNumberWithMatch.head._2 //a bit ugly but it works
  //so now we know where to slice
  val tocLines = lines.slice(startingIndex+1, startingIndex+25) //for now we are using magic number 20 we could also find the ending

  println(tocLines.mkString("\n"))

  //TODO filter and convert tocLines into story names only (without Roman numerals)
  //idea is notice that Roman numerals are all first and they have no spaces
  //so we want all text that is not first word
  val storyNames = for (line <- tocLines if (line.length > 0)) yield {
    //TODO do some more work here in preparing the line

    line
  } //this should filter empty llines
  println("*"*40)
  storyNames.foreach(println) //so we do have all the stories we just want to get rid of Roman numerals
}
