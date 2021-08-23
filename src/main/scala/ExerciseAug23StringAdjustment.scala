object ExerciseAug23StringAdjustment extends App {
  def processString(text:String, uppercaseChars:String =""):String = {
    //TODO replace All characters in uppercaseChars with their uppercase versions
    //one approach could be to have a variable which we keep changing each time for replacement with uppercase
    var resultText = text
    for (char <- uppercaseChars) {
      //you want to replace each of the characters with their uppercase version
      //so the idea is to use replace on result Text...
    }


    resultText //FIXME for now we return original text
  }

  println(processString("Valdis")) //here function works correctly already as a base/default case
  println(processString("Valdis", "ad")) //so we want to see "VAlDis"

  println("Valdis".replace("d", "D"))

}
