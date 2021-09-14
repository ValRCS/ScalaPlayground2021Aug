package com.github.valrcs

object ReadingWebResources extends App {
  val url = "https://www.gutenberg.org/files/61262/61262-0.txt" //url - universal resource locator
  val destinationFolder = "src/resources"
  //TODO how to I create the following automatically from any url with similar schema?
//  val destinationFile = "src/resources/61262-0.txt"
  val fileName = url.split("/").last //if it is somewhere in middle we would have to use the index
  val destinationFilePath = destinationFolder + "/" + fileName
//  val destinationFilePath = s"$destinationFolder/$fileName" //same as above but using string interpolation
  //usually 2nd would be clearer but here with / the first version is a bit more obvious
  println(s"Will save the text in $destinationFilePath")
  //  import scala.io.Source
//  val html = Source.fromURL(url) //does not have to html, just keep in mind this accessed external web address
//  val s = html.mkString
//
//  println(s.slice(0,100))
  println(s"Starting download from $url")
  val t0 = System.nanoTime()
  val myText = Utilities.getTextFromWeb(url)
  val t1 = System.nanoTime()
  val deltaMs = (t1 - t0)/1_000_000.0  //Milliseconds
  println(s"It took $deltaMs milliseconds to download from $url")
  println(s"Saving to $destinationFilePath")
  Utilities.saveText(destinationFilePath, myText, verbose = true) //notice we skipped append


}
