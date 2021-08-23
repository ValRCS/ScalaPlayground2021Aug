object ExerciseAug23StringAdjustment extends App {
  def processString(text:String, uppercaseChars:String =""):String = {
    //TODO replace All characters in uppercaseChars with their uppercase versions
    //one approach could be to have a variable which we keep changing each time for replacement with uppercase
    //TODO improvement idea get only unique characters from uppercaseChars, since we do not need duplicates for replacement
    //due to the way how replace replaces all instances
    var resultText = text //we are going to keep replacing this resultText
    //we are going to go through each of the replacement characters and going to replace them in our resultText
    for (char <- uppercaseChars) {
      //TODO we want to replace each character by character inside the loop
      println(s"Working on making ${char.toLower} uppercase to ${char.toUpper}")

      //we can't change characters in a string we have to create a new string instead
      //now we do not care what case the input uppercaseChars are
      resultText = resultText.replace(char.toLower,char.toUpper) //So we are going through our replacement characters one by one
      //and replacing them with their uppercase versions
      println(s"Current result is $resultText")
      //we can not replace text inside string but we can create a new string out of old string
      //you want to replace each of the characters with their uppercase version
      //so the idea is to use replace on result Text...
    }


    resultText
  }

  println(processString("Valdis")) //here function works correctly already as a base/default case
  println(processString("Valdis", "ad")) //so we want to see "VAlDis"
  println(processString(text="Baltijas Ceļš", uppercaseChars = "altijas")) //we want to see "BALTIJAS Ceļš"

//  println("Valdis".replace("d", "D"))
  println(processString("Oat meal porridge", "ae"))
  val food = "Oat meal porridge"
  println(food)
  println(food.replace("ae", "AE")) //this should do nothing since we have no matches...
  println(food.replace("ea", "EA")) //this should do nothing since we have no matches...

  //my function does this but for any sequence of characters
  var newFood = food
  println(newFood)
  newFood = newFood.replace("a", "A")
  println(newFood)
  newFood = newFood.replace("e", "E")
  println(newFood)

  println(processString("Banana bread surprise", "Ne"))
}
