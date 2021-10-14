package com.github.valrcs

import java.sql.{Connection, PreparedStatement}

object DBUtilities {
  val dbPath = "./src/resources/db/nim.db"
  val prefix = "jdbc:sqlite:"
  val url = "jdbc:sqlite:"+dbPath  //the prefix will change depending on your database type here we have sqlite

  import java.sql.DriverManager

  //TODO add option to add path as parameter
  def getConnection(dbPath:String):Connection = {
    val url = prefix + dbPath //remember url and dbPath are not related to values held in lines 6 and 7
    DriverManager.getConnection(url)
  }

  def createTable(conn:Connection):Unit = {
    println("Creating new table and dropping old one if it exists")
    val statement = conn.createStatement() //Creates a Statement object for sending SQL statements to the database. S

    // DROP TABLE IF EXISTS results; //how we would always drop the old table

    val sql =
      """

        |CREATE TABLE IF NOT EXISTS results (
        |	resultID INTEGER PRIMARY KEY,
        |   	player TEXT NOT NULL,
        |	win INTEGER DEFAULT 0,
        |	lose INTEGER DEFAULT 0
        |);
        |""".stripMargin

    statement.executeUpdate(sql)
  }

  /**
   *
   * @param conn - DB connection
   * @param player - player class to be inserted
   *  note: database statements are prepared  - it should really be without saying for user entered data
   */
  def insertPlayer(conn:Connection, player:Player):Unit = {
    println(s"Inserting Person $player")
    val insertSql = """
                      |INSERT INTO results(
                      |    player,
                      |    win,
                      |    lose
                      | )
                      |VALUES (?,?,?);
""".stripMargin

    val preparedStmt: PreparedStatement = conn.prepareStatement(insertSql)
    //sql 1 indexed here
    preparedStmt.setString (1, player.name)
    preparedStmt.setInt    (2, player.win)
    preparedStmt.setInt (3, player.loss)

    preparedStmt.execute
    //FIXME better performance to batch insert
    preparedStmt.close()


  }

}
