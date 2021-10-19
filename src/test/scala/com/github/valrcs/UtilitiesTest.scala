package com.github.valrcs

import org.scalatest.funsuite.AnyFunSuite

class UtilitiesTest extends AnyFunSuite {
  test("Utilities.add") {
    assert(Utilities.add(0,0) === 0)
    assert(Utilities.add(-1,1) === 0)
    assert(Utilities.add(0,1) === 1)
    assert(Utilities.add(2,2) === 4)
    //we could also test some really big numbers
  }
  //TODO for full coverage you could enter all months :)
  test(testName = "Utilities.getMonth") {
    assert(Utilities.getMonth(1) === "January")
    assert(Utilities.getMonth(12) === "December")
    assert(Utilities.getMonth(13) === "Invalid month")

  }
  test(testName = "Utilities.MYP") {
    //this is an example how to test for specific exceptions
    val thrown = intercept[ArithmeticException] {
      Utilities.MYP.toInt / 0
    }
    assert(thrown.getMessage === "/ by zero")
    assert(Utilities.MYP / 0 === Double.PositiveInfinity)
  }
}
