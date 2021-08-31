object ExerciseAug31PangramTester extends App {
  //TODO write a function isPangram which tests whether string is a pangram
  //https://en.wikipedia.org/wiki/Pangram
  //text can contain extra characters that is fine such as !., etc

  val alphabetArray = ('a' to 'z').toArray //we can create sequences out of characters not only numbers
  println(alphabetArray.mkString(""))
  val alphabet = alphabetArray.mkString("")

  def isPangram(text:String, alpha:String="abcdefghijklmnopqrstuvwxyz"):Boolean = {
    //TODO bonus if you can make it work with any alphabet it shouldnot take any extra work
    false //FIXME
  }

  println(isPangram("some text") == false)
  println(isPangram("The quick brown fox jumps over the lazy dog") == true)
  println(isPangram("The five boxing wizards jump quickly.") == true)
}

