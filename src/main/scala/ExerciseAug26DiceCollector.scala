import scala.util.Random.nextInt //so I want to use specific function from Random library

object ExerciseAug26DiceCollector extends App {
  println("Testing dice throws")
  for (n <- 0 to 30) println(nextInt(6))
  val singleDice = for (n <- 0 to 20) yield nextInt(6)+1 //n is not used we could have called it _
  println(singleDice.mkString(","))
  println(singleDice.count(_ == 6)) //syntax or for counting specific occurences

  //TODO create a value for number of dice throws (or ask user for number)
  //TODO create sequence of doubleDice throws
  //Calculate sum
  //Calculate average
  //Calculate max, and min (should be 12 and 2)
  //print number of times each number from 2 to 12 occurs in the sequence
}
