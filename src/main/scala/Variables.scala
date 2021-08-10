object Variables extends App {
  println("Scala has two kind of variables, val and var")
  val a = 15 //values stay constant, in some other languages they are called constants
  val b = 6
  var c = a + b //so c can be changed as many times as we wish (as long as it remains an whole number  integer)
  println(a,b,c)
  c = a*b //values can not be changed
  //in Scala we start by using values and only when absolutely necessary we use variables
  println(a,b,c)
  c = 55
  println(a,b,c)
//  println(a,b,c,d) //bad idea we are using d before it is created
  val d = a+b+c
  println(a,b,c,d)
  println("a+b=", a+b)

  val msg = "Hello, world!"
  println(msg)
  val mySum = a+b
  println(s"$a added to $b equals $mySum") //using s - string interpolation it lets us add variables inside our strings

  //Scala is strongly statically typed - meaning each variable and value has a specific type

  val myInteger:Int = 20 // :Int is not required , because Scala can figure out the type from 20

  var myNumber = 15
  println(myNumber)
  myNumber = 20
  println(myNumber)
//  myNumber = "Cant do this" //in Scala you can not change data types of variables , of course values can not be changed at all
  val myString:String = "Just a string" //again :String is not required
  println(myString)

  //one of the biggest challenges in programming is how to name things :)
  // x and y are great val and var names if they refer to x and y coordinates
  // x and y are not so good for say saving your name or your age

  val myName = "Valdis" //so this would be a good val name
  val lastName = "Saulespurens"
  println(s"Why hello there $myName $lastName")

  //in Scala we use something called camelCase for values, variables and many other things
  //but not for Objects those start with CapitalLetter
  val l = 333 //bad name, since l in many fonts is hard to distinguish from 1 or I

  //so takeaway is to use reasonably short but descriptive names for your variables

  val priceSalt = 0.27 //this is new data type - double, meaning it is a double precision floating point number
  val kgBought = 15
  val purchaseTotal = priceSalt * kgBought

  val purchaseMessage = s"$myName bought $kgBought kilos of salt at $priceSalt each. He paid $purchaseTotal total"
  println(purchaseMessage)

  val purchaseRounded = purchaseTotal.round //so round actually rounds to nearest integer
  println(s"Actually the total price was $purchaseRounded Euros")

  //TODO round to 2 decimal places
  //so with TODO we add a note to ourselves and colleagues to do something undone

  //FIXME is more serious but similar note, means something is not quite right

}
