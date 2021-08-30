object MapsIntro extends App {
  val myNumbers = (0 to 10).toArray
  println(myNumbers(3)) //so Indexed sequence we can look up values by their index
  println(myNumbers.mkString(","))

  //how would I go about storing my favorites, say food, car, color
  //well one way would be to create a mapping of food -> potatoes, car -> vw, color -> green
  //in other words we create a collection of key -> value pairs

  //so maps require keys to be unique, but values can be duplicate
  val myFavorites = Map(("food", "potatoes"), ("car", "vw"), ("color", "green"),("shirt","green"))
  println(myFavorites.mkString(","))

  //alternative syntax for creating Maps using -> notation
  //in this case we map strings to integers
  val anotherMap = Map("cats" -> 5, "dogs" -> 3, "kids" -> 3, "cars" -> 1)
  println(s"I have ${anotherMap("cats")} cats ")

  //you could even create a Map of integers mapping to strings, whic is kind of similar to indexed sequence,
  // //so it would be useful only if numbers tend to jump around with BIG gaps

  val numericMap = Map(100 -> "heroes", 300 -> "Spartans", 9000 -> "enough", 9001 -> "too much")
  println(numericMap(300))
}
