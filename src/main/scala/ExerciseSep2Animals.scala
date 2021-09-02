object ExerciseSep2Animals extends App {
  //TODO create some animals
  //TODO make the animals create some sounds :)
  val tom = new Animal("Tom", "cat", "Jerry", "meow", 7)
  tom.makeSound()
  tom.prettyPrint()
  tom.meet("Jerry")
  tom.meet("Spot")
  val jerry = new Animal("Jerry", animalType = "mouse", animalLikes = "Tom", animalSound = "eek eek", 3)
  jerry.prettyPrint()
  //it is possible to build a class which already utilizes an existing class a reference and continue from there
  //so we could define Cat or Mouse classes which use Animal blueprints as a starting point
}
