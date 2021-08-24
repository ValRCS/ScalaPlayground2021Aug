object Aug24FizzBuzzCollection extends App {
  //TODO create an Array[String] containing FizzBuzz values from 1 to 100 included

  //FIXME
  val myNumbers = (1 to 10).toArray

  //you can either yield or map
  //I recommend creating a helper function
  def getFizzBuzzText(n: Int)= {
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
