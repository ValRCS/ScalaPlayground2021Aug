package com.github.valrcs

import org.ini4j.{Ini, IniPreferences}

import java.io.File

object ReadingINI extends App {
  println("Reading INI files")
  val srcFile = "src/resources/ini/settings.ini"

  val ini = new Ini(new File(srcFile))
  val prefs = new IniPreferences(ini)

  println("My Name is " + prefs.node("People").get("name", null))

}
