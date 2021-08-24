object ArrayConcatenation extends App  {
  val smallNumbers = (1 to 10).toArray
  val bigNumbers = (100 to 109).toArray
  val combinedNumbers = smallNumbers ++ bigNumbers
  println(combinedNumbers.mkString(",")) //so mkString without start or end just separator

  //we can get creative and go from Ranges immediately to a completed IndexedSeq
  val numbersFromRanges = (1 to 5) ++ (30 to 33) ++ (55 to 59) ++ (-7 to -3) ++ (1000 to 960 by -4)
  println(numbersFromRanges.mkString(","))
}
