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

}
