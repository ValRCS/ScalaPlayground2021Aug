object Aug24FizzBuzzCollection extends App {
  //TODO create an Array[String] containing FizzBuzz values from 1 to 100 included and print it out
 //That is "1", "2", "3", "4", "Fizz", "6", "Buzz", "8" etc...

  //remember to includes the last number
  //and until does not include the last number
  val myNumbers = (1 to 100).toArray

  //you can either yield or map
  //I recommend creating a helper function
  def getFizzBuzzText(n: Int)= {
    //so if else if else if else produces something with 4 different outcomes and it is the last outcome so it is returned
    if ((n % 5 == 0) && (n % 7 == 0)) "FizzBuzz"
    else if ( n % 5 == 0 ) "Buzz"
    else if ( n % 7 == 0) "Fizz"
    else s"No.$n" //alternative since we have no other text we could to n.toString
  }

  //yield approach
  //n can be any name it just has to match name in getFizzBuzzText(..)
  val myFizzBuzz = for (n <- myNumbers) yield getFizzBuzzText(n)
  //n is gone here
  myFizzBuzz.foreach(println)

  //or we could also use map in fact yield translates to map underneath in Scala
  val myFizzBuzzToo = myNumbers.map(n => getFizzBuzzText(n))
  myFizzBuzzToo.foreach(println)
}
