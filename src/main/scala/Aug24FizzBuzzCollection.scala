object Aug24FizzBuzzCollection extends App {
  //TODO create an Array[String] containing FizzBuzz values from 1 to 100 included and print it out
  //That is "1", "2", "3", "4", "Fizz", "6", "Buzz", "8" etc...

  //FIXME
  val myNumbers = (1 to 10).toArray

  //you can either yield or map
  //I recommend creating a helper function
  def getFizzBuzzText(n: Int): String = {
    //FIXME
    if (n % 2 == 0) s"Even $n"
    else s"Odd $n"
  }

  //yield approach
  val myFizzBuzz = for (n <- myNumbers) yield getFizzBuzzText(n)
  myFizzBuzz.foreach(println)

  //or we could also use map
  val myFizzBuzzToo = myNumbers.map(n => getFizzBuzzText(n))
  myFizzBuzzToo.foreach(println)
}
