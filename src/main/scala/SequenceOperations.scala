object SequenceOperations extends App {
  val myText = "A quick brown fox jumped over a sleeping dog"
  val myWords = myText.split(" ") //i create a sequence out of string by splitting it by whitespace
  println(s"myText has ${myText.length} characters")
  println(s"myText has ${myWords.length} words")
  println(myWords.mkString(",")) //of course I could add white space as well

  val bigWords = for (word <- myWords) yield word.toUpperCase
  println(bigWords.mkString(":::"))

  println(myWords.slice(3,5).mkString(",")) //so in slicing the last index is not used in this case 6th item with index 5 is not used

  val numbers = (0 to 10).toArray
  val divBy3 = numbers.filter(n => n%3 == 0) //we are giving filter a function which tells us which numbers to keep when reminder is 0 when dividing by 3
  println(divBy3.mkString(","))
  val squares = numbers.map(n => n*n) //so in mapping we say what to do with each element in this case multiply by itself
  println(squares.mkString(","))
}
