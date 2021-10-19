package com.github.valrcs

import org.scalatest.funsuite.AnyFunSuite

class ExerciseOct11NimTest extends AnyFunSuite {

  //TODO make 3 asserts for each of these tests - so 9 total asserts
  test("testClampMove") {
    assert(ExerciseOct11Nim.clampMove(-1) === 1)
    assert(ExerciseOct11Nim.clampMove(0) === 1)
    assert(ExerciseOct11Nim.clampMove(1) === 1)
    assert(ExerciseOct11Nim.clampMove(2) === 2)
    assert(ExerciseOct11Nim.clampMove(3) === 3)
    assert(ExerciseOct11Nim.clampMove(4) === 3)
    //of course we could test with changed min and max values as well in parameters
  }

  test("testSmartComputer") {
    assert(ExerciseOct11Nim.smartComputer(4) === 3)
    assert(ExerciseOct11Nim.smartComputer(3) === 2)
    assert(ExerciseOct11Nim.smartComputer(2) === 1)
//    assert(ExerciseOct11Nim.smartComputer(1) === 3) //we cant really test since it is random :)
  }

  test("testGetComputerMove") {
    //so here i would have havet to test different levels of computer, almost a mini integration test since it uses other functions
    //such as smartComputer
  }

}
