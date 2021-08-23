object InflationCalculator extends App {
  //of course for this we could just use a formula
  def inflationCalculator(startingPrice: Double, inflationPercentage: Double, targetPrice: Double): Int = {
    var yearCounter = 0
    var currentPrice = startingPrice * (1 + inflationPercentage / 100)
    var isJobFinished = false //another common technique is to create extra flags
    if (currentPrice < startingPrice) {
        //we would like to return -1
        yearCounter = -1
//        return yearCounter //this is possible in Scala but discouraged to use early return
      isJobFinished = true //this is a bit ugly but it works
    }
    while (!isJobFinished && currentPrice < targetPrice) {
      currentPrice *= (1 + inflationPercentage / 100) // same as currentPrice = currentPrice * (inflationPercentage*100)
      yearCounter += 1 //one has passed same as yearCounter = yearCounter + 1
      println(s"After year $yearCounter price is $currentPrice")
    }

    yearCounter //this is always returned with some value
  }

  inflationCalculator(200, 8, 400)

  //this should take roughly 18 years if I remember my rule of 72 correctly
//  println(inflationCalculator(200, 4, 400))
  //what do we do if we can expect negative inflation?
  //we want to return - 1 when we have deflation
  println(inflationCalculator(150, -0.7, 200))

}
