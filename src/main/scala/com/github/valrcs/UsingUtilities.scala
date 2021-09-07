package com.github.valrcs //notice this was created automatically by intellij because we started in our package location
//so if i have something at the root of the project that I need to import I can use this _root_

object UsingUtilities extends App {
  println(Utilities.MYP) //so I can other objects, classes etc from the same package

  val newCar = Car("Bugatti") //i had to import com.github.valrcs.Car from _root_.com.github.valrcs.Car because it is in the root of the project without package

  println(newCar)
}
