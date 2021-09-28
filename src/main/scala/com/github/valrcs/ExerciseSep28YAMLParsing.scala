package com.github.valrcs

import org.yaml.snakeyaml.Yaml
import org.yaml.snakeyaml.constructor.Constructor

import java.io.{File, FileInputStream}
import scala.beans.BeanProperty

object ExerciseSep28YAMLParsing extends App {
  val srcPath = "src/resources/yaml/gameConfig.yaml"
  val input = new FileInputStream(new File(srcPath))

  //TODO create a new YAML parser to parse the input stream
  //TODO output maximum game length from the settings you create
  //so just modify the GameSettings
  //extra challenge get the topScores (the value of topScores key should pase out as List of Integers

}
