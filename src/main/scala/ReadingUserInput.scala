import scala.io.StdIn.readLine //we use import to add extra functionality to our program from extra libraries

object ReadingUserInput extends App {
  println("We will read some user input")
  val userName = readLine("What is your name friend?")
  //readLine will read user input until user presses Enter
  println(s"Great! Nice to meet you $userName!")
  val height = readLine(s"How tall are you $userName?")
  val megaHeight = height * 10 //well something unexpected will happen
  //we multiplied a string by 10 so Scala makes a copy of string 10 times...
  println(s"Your new height is $megaHeight")
  val trueHeight = height.toInt * 10 //so we nee to cast to Integer if we want integer math :)
  println(s"Your true height is $trueHeight")

  val topSpeed = readLine("What is the fastest you've driven?").toDouble //we cast immediately assuming users enter correct info
  //I could have cast to Int as well
  println(s"Wow! Your top speed was $topSpeed!")
}
