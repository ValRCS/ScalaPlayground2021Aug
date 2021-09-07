package com.github.valrcs

import scala.io.StdIn.readLine

object ExerciseSep7DaysOfWeek extends App {
  //TODO write a function that returns day of the week in English Monday, Tuesday
  //Given an index 1 to 7
  //if value is outside you return Unknown Weekday
  def getDayOfWeek (dayIndex: Int):String = dayIndex match {
    case 1 => "Monday"
    case 2 => "Tuesday"
    case 3 => "Wednesday"
    case 4 => "Thursday"
    case 5 => "Friday"
    case 6 => "Saturday"
    case 7 => "Sunday"
    case _ => "Unknown weekday"
  }
  for (day <- 0 to 8) println(getDayOfWeek(day))
  val dayOff = readLine("What day of the week do you want to take off?").trim.toInt
  val dayWeek =  getDayOfWeek(dayOff)
  val dayOffs = dayWeek
  println(s"Okay, $dayWeek will be a holiday for you, but only once :) ")


  if (dayOff == 6 || dayOff == 7) {
    println("No it is already a holiday")
  } else if (dayOff %2 ==0) {
    println ("No, Tuesdays and Thursdays we have an important tasks")
  } else {
    println("Okey you can have this day off :)")
  }
}
