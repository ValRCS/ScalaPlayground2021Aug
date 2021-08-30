object TupleExamples extends App {
  //tuples are a fixed collection of values of diferent types
  //in Scala they have an annoying syntax to access, but they are still useful
  //because of the abovementions different type support (which Array types cant do)

  val myTuple = ("name", "Valdis") //Seq would work fine here
  println(myTuple._1)
  println(myTuple._2)

  //so Tuples of size two are used to create Maps
  //but Tuples in Scala go to size 22 actually..
  val myBiggerTuple = ("food","drinks",100,200.33, true, Array(1,2,6), Map(("one"->1), ("two"->2)))
  println(myBiggerTuple._6.mkString(","))
  println(myBiggerTuple._7)
//  println(myBiggerTuple._7.getOrElse("two",0))
  println(myBiggerTuple._7.getOrElse("two",0))
  val myMapHiddenInTuple = myBiggerTuple._7
  println(myMapHiddenInTuple.getOrElse("two", 0)) //same result as line two lines above
  println(myMapHiddenInTuple.getOrElse("three", 0))

  //we can unpack the tuples
  val(food, drink, num1, num2, myBool, myArr, myMap) = myBiggerTuple

  //if we wanted to ignore some items we would use _ to signify that we do not care about them
  val(_,alsoDrink,_,_,_,_,_) = myBiggerTuple

  //we use Tuples to return multiple unrelated values at once in a function
  def prettyAdd(a:Int, b:Int) = {
    val res = a + b
    val stringRes = s"$a+$b=$res"
    (res, stringRes) //so we are returning a Tuple of Integer and String
  }

  val myRes = prettyAdd(5,23)
  println(myRes._1)
  println(myRes._2)
  println(myRes)
  //in the next line I unpack (actually pattern match ) the two values from the tuple that is being returned
  val (myInt, myString) = prettyAdd(30, 51)
  println(myInt)
  println(myString)

}
