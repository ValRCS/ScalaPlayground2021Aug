object Booleans extends App {
  val isRaining = false //not "false" that would be string!
  val isCold = true
  val a = 2
  val b = 3
  val pi = 3.1415926
  val result = 4

  val aBiggerThanB = a > b

  val equalNames = "Valdis" == "valdis" //so == has higher precedence(importance) over = so we go from right to left
  println(equalNames)

  println(5 >= 4) //5 is more or equal to 4
  println(5 >= 5)
  println(5 >= 6) //should be false

  println(2 <= 3)
  println(2 <= 2)
  println(2 <= 1) //should be false

  println(5 < 6)
  println(10 == 10)
  println(100 > 99)

  println("Valdis" > "Voldemars") //we can compare strings, but how?
  println("Valdis" > "Vold")

  println("V" > "A")
  println('V' > 'A') //we can compare single characters as well

  println("VAA" > "AZZZZZZ") // first string will win because first character wins

  //inequality
  println(5 != 10) //well that's a true statement
  println("Valdis" != "Voldis")

  println(2*2 != 4) //well we are checking an inequality but here it is equal, so the result will be false
  println(3 != 3) //again this is a false statement

  //so we can use ! to toggle true to false and vice versa

  var myToggle = true
  println(myToggle)
  myToggle = !myToggle
  println(myToggle)
  myToggle = !myToggle
  println(myToggle)

  //so ! negation work son Booleans, not integers not strings :)

  //we can combine logic statements //logical conjunction
  println(true && true)
  println(true && true && 5 == 5)
  println(true && false) //what will happen when we combine true and false?
  println(false && true)
  println(false && false) //of course also false

  //so Tar in Honey principle
  //one bad apple ruins everything
  println(true && true && true && false)

  println(true && 2*2 == 4 && 10 > 7 && "Val" > "Ab") //all true so everything should be true
  println(true && 2*2 == 7 && 10 > 7 && "Val" > "Ab") //one false will make everything false

  //there is also logical disjunction with || , logical OR

  println(true || true)
  println(true || false)
  println(false || true)
  println(false || false ) //only this will be false rest are true

  println(false || false || false || false || true || false) //one true statement makes OR true

  //usually we want to keep &&, || down to 2 -3 operations max

  // it is hard to remember which of && and || is more important so if you have to combine, you can use parenthesis

  println((true || false) && (false || true)) //should be true
  //usually the order does not matter but there are some exceptions
}
