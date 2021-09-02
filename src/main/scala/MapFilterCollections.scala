object MapFilterCollections extends App {
  val numbers = (0 to 20).toArray
  val divideBy5 = for (n <- numbers if n % 5 == 0) yield n
  println(divideBy5.mkString(","))
  //underneath it is actually using filter
  val dividedBy4 = numbers.filter(n => n % 4 == 0) //provide a function against which each item/number is checked
  println(dividedBy4.mkString(","))

  val bigNumbers = numbers.map(n => n*100) //yield is also using map
  println(bigNumbers.mkString(","))

  //how would be make squares out of only odd numbers
  //we could use yield or we could use map filter
  val oddSquares = for (n <- numbers if n % 2 == 1) yield n*n
  println(oddSquares.mkString(","))
  val oddSquaresAgain = numbers.filter(_ % 2 == 1).map(n => n*n) //so if we need the element twice we need to use full syntax
  //otherwise for single use we can use the short syntas with _
  println(oddSquaresAgain.mkString(","))
  val just3 = oddSquaresAgain.slice(0,3)
  just3.foreach(n => println(n)) //full syntax with function using arrow notation
  just3.foreach(println(_)) //shorter if we only need to use the item once
  just3.foreach(println) //even shorter if the function we are giving it uses single parameter

  def prettyPrint(number:Int) = println(s"The number is $number")

  just3.foreach(n => prettyPrint(n))
  just3.foreach(prettyPrint(_))
  just3.foreach(prettyPrint) //so my function needs to take a single parameter for the super short syntax to work

  prettyPrint(555)
}
