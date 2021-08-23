object StringLoops extends App {
  val myName = "Valdis" //so strings are a sequence of characters
  println(myName(0)) //indexing starts with 0 not 1
  println(myName(5)) //

  for (c <- myName) println(s"Current character is $c")

  //what if we want the index of the character?
  //remember until does not include the last number in this case the actual length, why do we want that?
  //well we start with 0 and we do not want to access the actual last number
  for (index <- 0 until myName.length ) println(s"Char no. $index is ${myName(index)}")

  //we can also enumerate our characters uzing zipWithIndex function
  for ((myChar, index) <- myName.zipWithIndex) println(s"Index $index and char is $myChar")

  val mySeq = for (c <- myName) yield c.toString //we will get a sequence of strings
  println(mySeq)

  //so Sequence is a new type of data structure it can be used to hold multiples of any data types (including sequences themselves)



}
