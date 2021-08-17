object ForLoops extends App {
  //we can do everything with while loops but for loops offer us convenience

  //we use for loops when we know exact number of items to go through
  for (i <- 0 to 5) { //to includes last number
    println(s"i is now $i")
  }
  //i will be gone here not accessible
  //so code is cleaner

  for (i <- 0 until 5) { //until does not include the last number
    println(s"i is now $i")
  }
  //we are reusing i again, but they are separate

  //for loops are suitable for going through anything that can be considered a sequence such as strings
  val myName = "Valdis"
  for (c <- myName) { //c commonly corresponds to character but it is fine to use something longer
    println(s"Current letter is $c")
  }
  for (letter <- myName) {
    println(s"Current letter is $letter")
  }

  //there is a convention ot use _ when value is not important

  for (_ <- 0 until 5) { //alternative would be 1 to 5
    println("Doing something but I do not care about the number")
  }

  //we will see more sequences when we go through more complex data types

  //loop variables usually you want a bit short, since they stop their lives outside

  myName.foreach(println) //we are saying for each individual member of myName print it
  for (myChar <- myName) println(myChar) //same as above

  for (number <- 0 until 10) {
    if (number % 2 == 0) { //these brackets ar enot strictly necessary for a single statement
      println(s"$number is even!")
    } else {
      println(s"$number is odd...")
    }
  }
}
