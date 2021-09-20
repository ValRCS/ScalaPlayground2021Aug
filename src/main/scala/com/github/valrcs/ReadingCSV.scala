package com.github.valrcs



object ReadingCSV extends App {
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

  val prices = veggieLines.map(_.price) //so we go through each veggie and get its price
  println(s"Max price is ${prices.max}")

  val maxPriceItems = veggieLines.filter(_.price == prices.max)
  maxPriceItems.foreach(println)

  val sortedVeggies = veggieLines.sortBy(_.price)
  sortedVeggies.slice(0,10).foreach(println)

  //so if we wanted mos expensive we could reverse the Array or slice, reverse would be cleaner
  println("Top 10 Most expensive")
  sortedVeggies.reverse.slice(0,10).foreach(println)

}
