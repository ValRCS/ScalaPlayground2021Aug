package com.github.valrcs

import scala.io.StdIn.readLine
import scala.util.Random.nextInt

object ExerciseOct11Nim extends App {

  //https://en.wikipedia.org/wiki/Nim
  //TODO add ScalaDoc to all functions
  //TODO migrate to Class based design for more organization
  val startingCount = 7
  val gameEndCondition = 0
  val minMove = 1
  val maxMove = 3
  val verbose = true
  val playerCount = readLine("How many players will be playing 1 or 2?").toInt
  val playerA = readLine("Player A what is your name?")
  val playerB = if (playerCount == 2) readLine("Player B what is your name?") else "Computer"
  val computerLevel = if (playerCount == 1) readLine("Computer Level (1-bad,3-best)").toInt else 1
  var gameState = startingCount
  var isPlayerATurn = true


  def beforeGame():Unit = {
    println(s"Player A $playerA and Player B $playerB let's play NIM!")
  }

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

  def randomComputer():Int = nextInt(maxMove)+minMove

  def smartComputer(gameState:Int): Int = {
    //so turns out we need some strategy based on reminder
    //only question is whether it is maxmove or was it MaxMove + 1
    //no matter what one person takes, the second person can always guarantee that both players take 4 matches
    //one takes 1 -> 3  2 -> 2 3 -> 1
    //so it certainly looks like first person should lose against a computer right?
    //second thing is strategy for computer when it is losing(against a smart player)
    //so we need to do match against reminder of 4
    gameState % 4 match {
      case 0 => 3 // so from 4 to 1 and oppon ent loses, works for 8, 12, 16, 20
      case 1 => randomComputer() //what to do when losing? :) my suggestion is play random then
      case 2 => 1 //so from 2 to 1 and opponent loses, so 2, 6, 10, 14,
      case 3 => 2 //so from 3 to 1 and again opponent loses, so 3, 7, 11, 15,19 and so on
//      case _ => 0 //this default should not happen all!
    }

  }

  //TODO create 3 levels of computer
  def getComputerMove(gameState:Int, level:Int=1): Int = {
    //so 1st level is here
    if (level == 1) {
      2
    } else if (level == 2) {
      randomComputer()  //random computer opponent
    } else {
      smartComputer(gameState) // we will need some more logic here so we will make another abstraction
    }// smart one at level 3 {
  }

  /**
   * Calculates the next move
   * @param playerName - player string with "Computer" signifying computer player
   * @return items to take from game board
   */
  def getMove(playerName:String):Int = {
    if (playerName == "Computer") {
      getComputerMove(gameState, computerLevel)
    } else {
      readLine(s"How many matches do you want to take $playerName?").toInt
    }
  }

  def singleGameLoop(): Unit = {
    while (gameState > gameEndCondition) {
      val currentPlayer = if (isPlayerATurn) playerA else playerB
      println(s"Currently there are $gameState matches on the table")
      val move = getMove(currentPlayer)
      gameState -= clampMove(move, minMove, maxMove, verbose) //same as gameState = gameState - move
      isPlayerATurn = !isPlayerATurn //toggle a trick to change booleans
      //ask for input
      //change game state
    }
  }

  /**
   * Resets game state to original
   */
  def resetGameState(): Unit = {
    gameState = startingCount
    isPlayerATurn = true
  }

  def mainGameLoop(): Unit = {
    var is_game_needed = true
    while (is_game_needed) {
      singleGameLoop()
      afterGame()
      val response = readLine("New game Y/N ?")
      if (response.toLowerCase.startsWith("y")) resetGameState()
      else is_game_needed = false  //in this case we end the game on anything other text starting with y or Y
    }

  }


  def saveWinnerLoser(saveFile: String, winner:String, loser:String): Unit = {
    //TODO implement
  }


  def displayTopPlayers(saveFile: String):Unit = {
    //TODO implement this func
  }

  def afterGame(): Unit = {
    val winner = if (isPlayerATurn) playerA else playerB
    val loser = if (!isPlayerATurn) playerA else playerB
    println(s"Game Ended. Congratulations $winner!   Better luck next time $loser")

  }


  //so start our game actually
  //TODO config also here
  beforeGame()
  mainGameLoop()


}
