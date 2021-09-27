package com.github.valrcs

import scala.xml.XML

object ExerciseSep27XMLReading {
  val srcFile = "src/resources/xml/books.xml"

  val xml = XML.loadFile(srcFile) //so val xml is points to the root element of this particular document

  //TODO create case class for the books
  //Read the books from the xml put them inside the case file, keep all the atributes and tags

  //TODO print the book objects(created from case class) in Ascending order of prices

}
