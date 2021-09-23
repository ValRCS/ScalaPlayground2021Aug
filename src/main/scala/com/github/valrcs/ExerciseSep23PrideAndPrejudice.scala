package com.github.valrcs



object ExerciseSep23PrideAndPrejudice extends App {
  //TODO download https://www.gutenberg.org/files/1342/1342-0.txt
  val url = "https://www.gutenberg.org/files/1342/1342-0.txt"
  val fileName = url.split("/").last //so this will work even if there is nothing to split
  val destPath = s"src/resources/$fileName"

  println(s"Will check if $destPath exists")
  println(Utilities.isFileThere(destPath))
  println(Utilities.isFileThere("src/resources/61262-0.txt"))


  //Preferably do it with Scala (not by hand :)
  //Save to src/resources
  //Read
  //extract all years meaning digits exactly 4 long
  //extract all words with Capital letters -

  // extra challenge would be to get words that are not first in sentence - not easy at all
}
