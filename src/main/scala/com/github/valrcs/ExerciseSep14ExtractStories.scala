package com.github.valrcs

object ExerciseSep14ExtractStories extends App {
  val srcPath = "src/resources/61262-0.txt"
  val lines = Utilities.getLinesFromFile(srcPath)
  println(s"There are ${lines.length} lines in $srcPath")

  //TODO get some stats about the file
  //TODO get character count across all lines - so how many symbols are in the file total
  val lineLengths = lines.map(_.length) //so for each line we get its length and store into an Array
  val charCount = lineLengths.sum
  val bigText = lines.mkString //so we put all lines next to each other into one big string
  val charCountToo = bigText.length
  println(s"There are $charCount =?= $charCountToo characters in the book")
  val bookText = lines.mkString("\n") //we include newlines for as that what the original lines ended with
  println(s"There were ${bookText.length} characters in the book including newlines")

  //TODO get word count (words here would mean words separated by one or more spaces this would include I and numbers

  val matchText = "CONTENTS"
  val linesNumberWithMatch = lines.zipWithIndex.filter(lineTuple => lineTuple._1.contains(matchText) )
  println(linesNumberWithMatch.head)
  val startingIndex = linesNumberWithMatch.head._2 //a bit ugly but it works
  //so now we know where to slice
  val tocLines = lines.slice(startingIndex+1, startingIndex+25) //for now we are using magic number 20 we could also find the ending

  println(tocLines.mkString("\n"))

  //we will split by one or more (+) whitespaces
  val wordsInLines = lines.map(_.split(" +")) //so for each line we create an array of Strings (words)
  wordsInLines.slice(0,25).foreach(arr => println(arr.mkString(":::")))
  val wordCountPerLine = wordsInLines.map(_.length)
  wordCountPerLine.slice(0,25).foreach(println)
  println("*"*40) //just some divider for visuals
  val wordCountAlso = Utilities.getWordCountPerLine(lines)
  wordCountAlso.slice(0,25).foreach(println)

  //TODO filter and convert tocLines into story names only (without Roman numerals)
  //idea is notice that Roman numerals are all first and they have no spaces
  //so we want all text that is not first word
  val storyNames = for (line <- tocLines if (line.length > 0)) yield {
    //TODO do some more work here in preparing the line

    line
  } //this should filter empty lines
  println("*"*40) //just some divider for visuals
  storyNames.foreach(println) //so we do have all the stories we just want to get rid of Roman numerals
}
