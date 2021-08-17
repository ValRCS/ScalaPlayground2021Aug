import scala.io.StdIn.readLine

object ExerciseAug17Factorial extends App {
  //TODO write code to calculate Factorial from user entry
  //factorial of 0 is 1 (special case)
  //factorial of 1 is 1
  //factorial of 2 is 1*2
  //factorial of 3 is 1*2*3
  //factorial of 4 is 1*2*3*4
  //of course for truly large numbers we will need a bigger number type...

  val number = readLine("Please enter a whole number for which  you want factorial").trim.toInt
  println(s"Will calculate factorial of number $number")
  //we could use while loop or we could also use a for loop

  //we will need some variable to store intermediate results
  var result = 1
  //so next line should do nothing if number is less than 2
  for (n <- 2 to number) result *= n // same as result = result * n
  println(s"Factorial of $number is $result")

  //we could go the other way as well
  var resultToo = number //resultToo not the best name :0
  for (n <- number-1 to 2 by -1) resultToo *= n
  println(s"Fact $number is $resultToo")

  //we could have used while loop but it would be longer
  var resultAgain = 1
  var n = 2
  while (n <= number) {
    resultAgain *= n
    n += 1
  }
  println(s"Fact again of $number is $resultAgain")

  result = 1 //reset result
  for (n <- 2 to number) {
    result *= n
    println(s"n is $n, result so far is $result")
  } // same as result = result * n
  println(s"Factorial of $number is $result")

  var addResult = 0 //for addition we would do zero
  for (n <- 1 to number) addResult += n
  println(s"sum of numbers from 1 to $number is $addResult")
  //there is the Gauss formula for this
  //and also a shorter way of doing it for simple summation
  println((1 to number).sum)
}
