package com.github.valrcs

import org.yaml.snakeyaml.Yaml
import org.yaml.snakeyaml.constructor.Constructor

import java.io.{File, FileInputStream}
import scala.beans.BeanProperty

object ExerciseSep28YAMLParsing extends App {
  val srcPath = "src/resources/yaml/gameConfig.yaml"
  val input = new FileInputStream(new File(srcPath))
  val yaml = new Yaml(new Constructor(classOf[BigGameSettings]))
  //TODO create a new YAML parser to parse the input stream
  //TODO output maximum game length from the settings you create
  //so just modify the GameSettings
  //extra challenge get the topScores (the value of topScores key should pase out as List of Integers
  val settings = yaml.load(input).asInstanceOf[BigGameSettings]

  println(settings.gameLength)
  settings.topScores.forEach(println)
  println(settings)

  settings.topScores.add(9000) //IN PLACE modification

  val destPath = "src/resources/yaml/newSettings.yaml"

  import java.io.FileWriter

  val writer: FileWriter = new FileWriter(destPath)
  yaml.dump(settings, writer)

}


class BigGameSettings {
  //so we are giving hints to the parser on what type of data to expect
  //making some default values
  @BeanProperty var defaultMatches = 0
  @BeanProperty var minStartingMatches = 0
  @BeanProperty var maxStartingMatches = 0
  @BeanProperty var playerA = "Player A"
  @BeanProperty var playerB = "Player B"
  @BeanProperty var maximumScore = 0
  @BeanProperty var gameLength = 0
  @BeanProperty var topScores = new java.util.ArrayList[Int]() //so blank Array of Ints as default
  override def toString: String = s"player A: $playerA, userB $playerB defaultMatches: $defaultMatches"
}