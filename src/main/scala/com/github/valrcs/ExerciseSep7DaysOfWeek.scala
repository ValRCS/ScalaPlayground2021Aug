package com.github.valrcs

object ExerciseSep7DaysOfWeek extends App {
  //TODO write a function that returns day of the week in English Monday, Tuesday
  //Given an index 1 to 7
  //if value is outside you return Unknown Weekday
  def getDayOfWeek(dayIndex: Int):String = {
    "Monday" //FIXME
  }


  //test
  for (d <- 0 to 8) println(getDayOfWeek(d))
}
