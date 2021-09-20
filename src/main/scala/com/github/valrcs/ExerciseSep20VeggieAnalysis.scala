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

  val onlyApples = veggieLines.filter(_.item == "apples")
  val applePrices = onlyApples.sortBy(_.price)
  println("Most expensive apples")
  applePrices.reverse.slice(0,5).foreach(println)
  println("Less expensive apples")
  applePrices.slice(0,5).foreach(println)
  val appleItemPrice = onlyApples.map(_.price)
  println(s"Apple max price is ${appleItemPrice.max}")
  println(s"Apple min price is ${appleItemPrice.min}")

  val onlyLettuce = veggieLines.filter(_.item == "lettuce")
  //val lettuceYear = onlyLettuce.filter(_.date)
  val lettucePrices = onlyLettuce.map(_.price)
  val avgLettucePrice = lettucePrices.sum / onlyLettuce.length
  val averageLettucePrice = (lettucePrices.sum / onlyLettuce.length) - (lettucePrices.sum / onlyLettuce.length % 0.01)
  println(s"The average price of lettuce is $averageLettucePrice or is it $avgLettucePrice")

  //the idea is to group by year

  val numbers = (0 to 12).toArray
  val groupedNumbers = numbers.groupBy(_ % 4) // so we group numbers by their reminder when divided by 4
  for ((key, value) <- groupedNumbers) {
    println(s"Reminder $key")
    println(s"Values")
    println(value.mkString(","))
  }

  val groupedByCategory = veggieLines.groupBy(_.category)
  val topCount = 5
  for ((key, value) <- groupedByCategory) {
    println(s"Category $key")
    println(s"Top $topCount Most expensive")
    val sortedValues = value.sortBy(_.price)
    println(sortedValues.reverse.slice(0,topCount).mkString("\n"))
  }

  //so we could group by year if we had it well we could do it a hot run just need year from split

  val groupedByYear = onlyLettuce.groupBy(_.date.split("-").head) //we group by year which we extract on the run
  for ((key, value) <- groupedByYear) {
    println(s"Category $key")
    println(s"Top $topCount Most expensive")
    val sortedValues = value.sortBy(_.price)
    println(sortedValues.reverse.slice(0,topCount).mkString("\n"))
    val prices = value.map(_.price)
    println(s"For year $key lettuce prices ranged from ${prices.min} to ${prices.max}")
  }
  //Mappings do not guarantee specific order we could use sorted Map we can try
  import scala.collection.SortedMap
  //https://stackoverflow.com/questions/3074118/how-do-i-convert-a-mapint-any-to-a-sortedmap-in-scala-or-a-treemap
  val sortedByYear = SortedMap(groupedByYear.toArray:_*) //so this trick recasts any map to sortedmap
  for ((key, value) <- sortedByYear) {
    println(s"Category $key")
    println(s"Top $topCount Most expensive")
    val sortedValues = value.sortBy(_.price)
    println(sortedValues.reverse.slice(0,topCount).mkString("\n"))
    val prices = value.map(_.price)
    println(s"For year $key lettuce prices ranged from ${prices.min} to ${prices.max}")
  }
}
