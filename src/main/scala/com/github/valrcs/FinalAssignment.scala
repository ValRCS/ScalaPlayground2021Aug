package com.github.valrcs

object FinalAssignment extends App {
  val srcFile = "src/resources/final_project_participants.txt"
  val lines = Utilities.getLinesFromFile(srcFile)
  println(lines.size)
  val emails = lines.map(line => line.split(" ").last).sorted
  emails.foreach(println)

  //one idea is to shuffle the emails and then just pick them up by twos
  import scala.util.Random
  val shuffled = Random.shuffle(emails.toList)
  val pairs = shuffled zip shuffled.reverse //so we create a list of tuples out of our email list
  pairs.foreach(println)
  Utilities.saveLines("src/resources/pairs.txt", pairs.map(t => t._1 + " , " + t._2).toArray)

}
