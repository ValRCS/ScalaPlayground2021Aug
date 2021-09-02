//TODO add class variables name, animalType, likes, sound- all strings and age which is Int
//class Animal(  ) {
//  //TODO add class method makeSound which prints sound
//
//  //BONUS
//  //TODO add class method meet which has a parameter of contact:String
//  //TODO this meet should decide whether to greet if they like the contact
//  //TODO to run away if they do not like the contact
//
//
//}
class Animal (var animalName: String, var animalType: String, var animalLikes: String, var animalSound: String, var animalAge: Int) {

  def makeSound(): Unit  = println(s"$animalSound")

  def prettyPrint(): Unit  ={
    println(s"My animal's name is $animalName, it's a $animalType, it likes $animalLikes, it is $animalAge years old")
  }
  //this function depends on contents of animalLikes so this OOP style
  def meet (contact:String): Unit =
  {
    if (contact == animalLikes) println("greet")
    else println("run away")
  }
}