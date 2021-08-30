import scala.io.StdIn.readLine

object ExerciseAug30Maps extends App {
    println("Split sentence into words")
    println("Create a mapping of words to word lengths")

    val sentence = readLine("What is your sentence friend?")
    val words = sentence.split(" ")

    //TODO
    //val myMap which contains keys of each word and values would be integers of word length
    //remember each string has attribute length.

    //you can use yield to create immutable map , or use the above for loop and mutable Map
    //println(myMap)
    val myMap = (for (word <- words) yield (word, word.length)).toMap
    println(myMap)

  //less recommended would be to use a mutable map //this is how many older languages do it
  val mutableMap = scala.collection.mutable.Map[String, Int]() //an empty Map to be filled
  for (word <- words) {
    println("Adding", word, word.length)
    mutableMap += (word -> word.length)
  }
  println(mutableMap)

  //contents of both are same but order is different
  //if you really want the insertion order(not usually important)
  //we can use mutable  LinkedHashMap
  val mutableLinkedHashMap = scala.collection.mutable.LinkedHashMap[String, Int]() //an empty Map to be filled
  for (word <- words) {
    println("Adding", word, word.length)
    mutableLinkedHashMap += (word -> word.length)
  }
  println(mutableLinkedHashMap)
}
