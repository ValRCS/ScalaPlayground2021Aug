import com.github.valrcs.Car

// Scala program to illustrate the
// implementation of inheritance
//https://www.geeksforgeeks.org/inheritance-in-scala/
// Base class
class Geeks {
  var Name: String = "Ankita"
  def simplePrint: Unit = println(s"Simple print name is $Name")

  //we can override existing methods that are built in
  //for example to have print give out my custom print
  override def toString: String = s"Object of class: ${getClass.getName} Custom name is $Name"
  //so we created our own string to be used whenever println is used on objects of this Geeks class
}

// Derived class
// Using extends keyword
class Geeks2 extends Geeks //so we
{
  var Article_no: Int = 130

  // Method
  def details()
  {
    println("Author name: " +Name)
    println("Total numbers of articles: " +Article_no)
  }

  override def simplePrint: Unit = {
    super.simplePrint //this calls the original simplePrint of the parent not always needed
    println(s"My own extra printing of article: $Article_no")
  }
}

//https://docs.scala-lang.org/overviews/scala-book/constructors-default-values.html
//we can write default values so just like for functions, so we can create our objects with different syntax
class Socket(var timeout: Int = 2000, var linger: Int = 3000) {
  override def toString = s"timeout: $timeout, linger: $linger"
}

object Main
{

  // Driver code
  //defining main function is an alternative to using extends App
  def main(args: Array[String])
  {

    val mainOb = new Geeks()
    println(mainOb)
    println(mainOb.Name)
    mainOb.simplePrint //if I do not need parameters i can skip parenthesis
    // Creating object of derived class
    val ob = new Geeks2()
    ob.Name = "Hulk"
    ob.details()
    ob.simplePrint
    println(ob)

    val socketA = new Socket()
    val socketB = new Socket(1500)
    val socketC = new Socket(1200, 5000)
    println(socketA)
    println(socketB)
    println(socketC)

    val cars = for (_ <- 0 to 4) yield Car()
    //so we will have 5 cars with identical properties but they will be different objects
    cars.foreach(println)
    for (car <- cars) println(car) //same as above line

    val vw = Car(make = "VW", color="gray", model="Touran")
    println(vw)
  }
}