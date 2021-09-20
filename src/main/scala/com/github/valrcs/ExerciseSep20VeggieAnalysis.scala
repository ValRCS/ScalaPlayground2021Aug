package com.github.valrcs

object ExerciseSep20VeggieAnalysis extends App {
  val srcFile = "src/resources/csv/veggie_prices_21.csv"
  val lines = Utilities.getLinesFromFile(srcFile)
  lines.slice(0,10).foreach(println)
  // we actually want to get each value in each line, so we need to split
  //we can use yield or map (same thing underneath)
  val splitLines = lines.map(_.split(",")) //so we told how to split each line
  splitLines.slice(0,10).foreach(line => println(line.mkString(";")))

  def arrayToVeggie(arr:Array[String]):Veggie = {
    //the hard part with CSV is handling bad cases
    //you would want to add some error handling here
    Veggie(arr(0), arr(1), arr(2), arr(3), arr(4).toDouble, arr(5))
  }


  //ideally we would want to get more structure for this CSV, how to do that?
  //one useful idea is to use a case  class to hold one row

  //I used tail, because first line was the actual column names
  val veggieLines = splitLines.tail.map(line => arrayToVeggie(line)) //so map is a loop we just loop through

  println(s"There are ${veggieLines.length} items in price database")

  //TODO get the top 5 most expensive apple entries
  //TODO get the least expensive 5 apple entries

  //TODO get average price for lettuce
  //TODO extra credit get average price for lettuce by year

  val lettuce = veggieLines.filter(_.item.contains("lettuce"))
  lettuce.slice(0,7).foreach(println)
}
