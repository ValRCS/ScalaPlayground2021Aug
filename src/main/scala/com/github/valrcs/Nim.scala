package com.github.valrcs

import scala.io.StdIn.readLine

object Nim extends App {
  //https://en.wikipedia.org/wiki/Nim
  //TODO support 2 player mode
  //TODO support computer mode
  //TODO add different computer skill levels

  //TODO migrate to Class based design for more organization
  val startingCount = 21
  val gameEndCondition = 0
  val minMove = 1
  val maxMove = 3
  val verbose = true
  val playerCount = readLine("How many players will be playing 1 or 2?").toInt
  val playerA = readLine("Player A what is your name?")
  val playerB = readLine("Player B what is your name?")
  var gameState = startingCount
  var isPlayerATurn = true

  println(s"Player A $playerA and Player B $playerB let's play NIM!")

  def clampMove(move:Int, min:Int = 1, max:Int = 3, verbose:Boolean = false): Int = {
    if (move > max) {
      if (verbose) println(s"$move is too much, you will have to settle for $max")
      max
    } else if (move < min) {
      if (verbose) println(s"$move is too little, you will have to settle for $min")
      min
    } else {
      move
    }
  }

  while (gameState > gameEndCondition) {
    val currentPlayer = if (isPlayerATurn) playerA else playerB
    println(s"Currently there are $gameState matches on the table")
    val move = readLine(s"How many matches do you want to take $currentPlayer?").toInt
    gameState -= clampMove(move, minMove, maxMove, verbose) //same as gameState = gameState - move
    //TODO limit the number of matches taken
    isPlayerATurn = !isPlayerATurn //toggle a trick to change booleans
    //ask for input
    //change game state
  }

  val winner = if (isPlayerATurn) playerA else playerB
  val loser = if (!isPlayerATurn) playerA else playerB
  println(s"Game Ended. Congratulations $winner!   Better luck next time $loser")


}
