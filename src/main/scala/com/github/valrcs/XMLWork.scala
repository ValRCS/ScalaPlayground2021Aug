package com.github.valrcs

import scala.xml.XML

object XMLWork extends App {
  val srcFile = "src/resources/xml/books.xml"

  val xml = XML.loadFile(srcFile) //so val xml is points to the root element of this particular document

  println(xml)
}
