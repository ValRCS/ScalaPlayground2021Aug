package com.github.valrcs

import scala.collection.mutable.ArrayBuffer
import scala.io.StdIn.readLine
import scala.util.Random.nextInt

object ExerciseOct11Nim extends App {

  //https://en.wikipedia.org/wiki/Nim
  //TODO add ScalaDoc to all functions
  //TODO migrate to Class based design for more organization
  val statsFile = "src/resources/nim/stats.tsv" //so tab separated values
  val statsDB = "src/resources/db/nim.db"
  //for bigger database you might also have user name and password which you should not store in code
  //instead it should be loaded from enviroment variables //TODO next week
  val startingCount = 7
  val gameEndCondition = 0
  val minMove = 1
  val maxMove = 3
  val verbose = true
  //we put some default values in case we forget to initialize
  var playerCount = 2
  var playerA = "Player A"
  var playerB = "Player B"
  var computerLevel = 1

  var gameState = startingCount
  var isPlayerATurn = true

  var playerMap = scala.collection.mutable.Map[String, Player]() // so fresh map of strings mapping to Player

  def updatePlayer(playerName:String, isWinner:Boolean):Unit = {
    //https://alvinalexander.com/scala/how-to-add-update-remove-mutable-map-elements-scala-cookbook/
    val win = if (isWinner) 1 else 0
    val loss = if (isWinner) 0 else 1

    if (playerMap.contains(playerName)) {
      val player = playerMap.get(playerName).getOrElse(Player())
      player.win += win
      player.loss += loss
    } else {
      val player = Player(playerName, win, loss)
      playerMap += (playerName -> player)
      //so here we would also insert the player into our database
      val conn = DBUtilities.getConnection(statsDB)
      DBUtilities.insertPlayer(conn, player)
    }
  }

  def initPlayerSettings():Unit = {
    playerCount = readLine("How many players will be playing 1 or 2?").toInt
    playerA = readLine("Player A what is your name?")
    playerB = if (playerCount == 2) readLine("Player B what is your name?") else "Computer"
    computerLevel = if (playerCount == 1) readLine("Computer Level (1-bad,3-best)").toInt else 1
  }

  def initAllGameSettings():Unit = {
    initPlayerSettings()
    resetGameState()
  }



  def loadGameStats(statsFile:String, use_database:Boolean=true):Map[String,Player] = {
    if (use_database) {
      loadGameStatsFromDB(statsFile)
    } else {
      loadGameStatsFromTSV(statsFile)
    }
  }

  def loadGameStatsFromDB(dbFile:String):Map[String,Player] = {
      //TODO connect to DB
    //SELECT * FROM results
    //parse into Map of Players
    val conn = DBUtilities.getConnection(dbFile)
    val statement = conn.createStatement()

    val newSQL =
      """
         |SELECT * FROM results
         |""".stripMargin

    val newResultSet = statement.executeQuery(newSQL)
    val playerList = ArrayBuffer[Player]() //to hold players while i get all of them
    while (newResultSet.next())  {
      val name = newResultSet.getString(2)
      val win = newResultSet.getInt(3)
      val loss = newResultSet.getInt(4)
      val player = Player(name, win, loss)
      playerList += player
    }
    //so i need to cast it to Map of player names and Player objects
    playerList.map(player => (player.name -> player)).toMap
  }

  def loadGameStatsFromTSV(statsFile:String, sep:String = "\t"):Map[String,Player] = {
    val lines = Utilities.getLinesFromFile(statsFile)
    val splitLines = lines.tail.map(line => line.split(sep))
    val playerList = for (lineArr <- splitLines) yield {
      lineArr match {
        //so if we get array of 3 strings we can create our player otherwise we create a blankie
        case Array(player, win, loss) => Player(player, win.toInt, loss.toInt)
        case _ => Player()
      }
    }
    playerList.map(player => (player.name -> player)).toMap
  }

  def beforeGame():Unit = {
    initAllGameSettings()
    // TSV based loading
    // playerMap = loadGameStats(statsFile, use_database = false).to(collection.mutable.Map) //we will need to mutate this map
    playerMap = loadGameStats(statsDB).to(collection.mutable.Map) //we will need to mutate this map
    displayGameStats()
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

  def getPlayerListFromMap(playerMap:scala.collection.mutable.Map[String, Player]):Array[Player] = {
    //so we go through our map and only yield the values(Players) wich we convert to Array and sort by wins Descending
    (for ((playerName,player) <- playerMap) yield player).toArray.sortBy(_.win).reverse
    //TODO add default parameters for sorting ascending, descending, win or loss etc, low priority
  }

  def saveToDatabase(playerList:Array[Player]):Unit = {
    val conn = DBUtilities.getConnection(statsDB)
//    DBUtilities.createTable(conn) // we really want to do createTable once
//    // so above should be separate program or do it by hand in DBeaver etc
//    playerList.foreach(player => DBUtilities.insertPlayer(conn, player)) //we only want to insert once
    playerList.foreach(player => DBUtilities.updatePlayer(conn, player)) //we only want to insert once
    //FIXME make sure that player exists (meaning we want to insert new players as well)

  }

  def savePlayerStats(saveFile:String, playerList:Array[Player]):Unit = {
    println(s"Saving ${playerList.length} players into $saveFile")
    //first we need to conver our player objects to strings that would be somewhat formatted
    //so we create an array of lines to save
    //first line will be our header
    //rest will be our players transformed into strings using our little string function
    val playerStrings = Array("name\twin\tloss") ++ playerList.map(player => player.getPrettyRow())
    Utilities.saveLines(saveFile, playerStrings)

    //TODO save stats in DataBase as well
    saveToDatabase(playerList)
  }

  def displayGameStats():Unit = {
    //TODO show player wins losses here
    //so we need to go through playerMap and show some results
    println("Show game stats preferably sorted by wins")
    //simple unsorted key value print
//    for ((key,value) <- playerMap) {
//      println(s"Player: $key -> $value")
//    }
    val playerList = getPlayerListFromMap(playerMap)
    println("PlayerName\tWin\tLoss")
    playerList.foreach(player => println(player.getPrettyRow()))

    println("*"*40)
  }


  def mainGameLoop(): Unit = {
    var is_game_needed = true
    while (is_game_needed) {
      singleGameLoop()
      afterGame()
      val response = readLine("New game Y/N ?")
      if (response.toLowerCase.startsWith("y")) {
        val newPlayerResponse = readLine("New Players ? Y/N")
        if (newPlayerResponse.toLowerCase.startsWith("y")) {
          initPlayerSettings()
        }
        resetGameState() //we need to reset game state no matter if we have new players
        displayGameStats()
      }
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
    updatePlayer(winner, isWinner = true)
    updatePlayer(loser, isWinner = false)
  }

  def cleanupAfterAllGames(): Unit = {
    //TODO actually cleanup if needed, meaning closing open connections to database, online resources etc.
    println("ALl games ended, cleaning up, you don't have to go home, but you can't stay here..")
    displayGameStats()
    savePlayerStats(saveFile = statsFile, getPlayerListFromMap(playerMap))
  }


  //so start our game actually
  //TODO config also here
  beforeGame()
  mainGameLoop()
  cleanupAfterAllGames()


}
