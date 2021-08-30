import scala.io.StdIn.readLine

object ExerciseAug30Maps extends App {
    println("Split sentence into words")
    println("Create a mapping of words to word lengths")

    val sentence = readLine("What is your sentence friend?")
    val words = sentence.split(" ")

    //TODO
    //val myMap which contains keys of each word and values would be integers of word length
    //remember each string has attribute length.
    for (word <- words) {
      println(word, word.length)
    }
    //you can use yield to create immutable map , or use the above for loop and mutable Map
    //println(myMap)
}
