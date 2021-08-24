object CollectionsIntro extends App {
//  val a = 5
//  val b = 15
//  val c = 35
//  //we want to store a lot of integers
//  //we could do this..
//  val a1 = 6
//  val a2 = 7
//  val a3 = 8
  //avoid this as much as possible.!
  //if we want to store similar type of data we reach for some sort of collection
  val myArray = Array(1,2,3,4,10,30,5314,32,52)

  println(myArray.head) //same as myArray(0)
  println(myArray(4)) //what will this print? 4 or 10 ?
  println(myArray.last)
  println(myArray(myArray.length-1)) //same as last
  println(myArray.length) //this will be 9 but we can not access myArray(9) since that would be 10th element
//  println(myArray(9)) //this will be out of bounds exception
  println(myArray(8))
  println(myArray.sum)
  println(myArray.min)
  println(myArray.max)
  val avg= myArray.sum / myArray.length
  println(s"average from my array is $avg but that is an integer avg")
//  val avgDouble  = 1.0 * myArray.sum / myArray.length // I am saying i want the result stored as Double floating point avlue
  val avgDouble  = myArray.sum.toDouble / myArray.length //this is a bit more clear

  println(s"average from my array is $avgDouble which is a double")

  for (element <- myArray) println(element)
  myArray.foreach(println) //even shorter way of printing all elements one by one

  //by default Collections are immutable, Scala prefers immutable, so how would i go about creating a new array from old array
  val arr200 = for (number <- myArray) yield number * 200 //I create a new array from old array items one by one
  arr200.foreach(println)

  //so yield creates a new element for a new collection out of an existing collection it works together with for loop

  //I can even create collections with new data types
  val myTexts = for (n <- myArray) yield s"Item in my collection is $n"
  myTexts.foreach(println)

  val moreTexts = for ((item, index) <- myArray.zipWithIndex) yield s"Number No. $index is $item"
  moreTexts.foreach(println)

  val numbers = (0 to 10).toArray //quicker than writing Array(0,1,2,3...,10)
  numbers.foreach(println)

  val squares = for (n <- numbers) yield n*n
  squares.foreach(println)

  //we could do this with mutable sequence but it is discouraged

  val evenSquares = squares.filter(n => n % 2 == 0) //for filtering we need to enter what the condition for each element needs to be true
  evenSquares.foreach(println)

  //we can filter with yield as well by putting if inside
  val evenSquaresToo = for (n <- squares if n % 2 == 0) yield n
  evenSquaresToo.foreach(println)

  //how about adding some text whether number is even or odd
  val myNumberDescriptions = for (n <- squares) yield {
    //i could do some extra stuff here first
    //my last line should be what I want to yield
    if (n % 2 == 0) s"Even square $n"
    else s"Odd square $n" //remember we are returning the last line in our block of { }
  }
  myNumberDescriptions.foreach(println)
}
