import scala.io.StdIn.readLine

object ExerciseAug16BonusCalculator extends App {
  println("Xmas bonus calculator")
  //TODO
  //Ask for person's name
  //Ask for how long they have worked at the firm
  //Ask for monthly wage
  //Calculate Xmas bonus if they have worked at least 2  years
  //Bonus is years worked over 2 years * 15% of monthly wage
  //so 5 years worked, 1000 Euros wage would give 450 Euro bonus (3 years * 150)

  //if they are not eligible for bonus you should say so
  //Līva's solution

//  val userName = readLine("What is your name?")
//  val userExperience = readLine("For how many years have you worked at this firm?").toInt
//  if (userExperience<=2) println(s"Sorry, $userName, You are not eligible for bonus yet")
//  else {
//    val userWage = readLine("What is your monthly wage?").toDouble
//    val userBonusPerYear = userWage * 1.15 - userWage // 0.15 * userWage would work just as well
//    val xmasBonus = ((userExperience - 2) * userBonusPerYear).round
//    println(s" $userName, Your christmas bonus is $xmasBonus eur ")
//  }
//Katya's solution
//  println("Xmas bonus calculator")
//  val personsName = readLine(s"Whats is your name, sir/madam?")
//  println (s"Great to meet you! Lets calculate your Christmas bonus!")
//  val yearsWorked= readLine( s"$personsName, how long have you worked for the company?").toInt //so integer if you expect people to obey instrution and only use integers
//  if ( yearsWorked < 2 ) {
//    println(s"I m sorry $personsName, you are not entitled to Christmas bonus this year. ")
//  } else println("Lets calculate your Christmas Bonus!")
//  val salary = readLine (s"$personsName, what's your monthly salary?").toDouble
//  val yearlyBonus = salary * 15 / 100 * (yearsWorked-2) // not needed .toDouble
//  println (s"Your bonus is ${yearlyBonus}")

  //Jolanta's solution
  val name = readLine("Enter your name: ")

  //Ask for how long they have worked at the firm
  val years = readLine("How long are you working at the firm?").toDouble

  //Ask for monthly wage
  val wage = readLine("What is your monthly wage?").toDouble

  //Calculate Xmas bonus if they have worked at least 2  years
  //Bonus is years worked over 2 years * 15% of monthly wage
  //so 5 years worked, 1000 Euros wage would give 450 Euro bonus (3 years * 150)

  //if they are not eligible for bonus you should say so
  if (years >= 2) {
    val bonus = (years-2) * (wage*0.15)
//    val bonus = ((years-2) * (wage*0.15)*100).round /100 //remember to round at the last possible moment you do not want to round too many times
    //above example is how we round to 2 digits after zero
    println(s"Congratulations your bonus is $bonus")
  }
  else {
    println("You are not eligible for the bonus.")
  }

}
