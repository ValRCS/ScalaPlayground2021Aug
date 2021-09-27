package com.github.valrcs

import scala.xml.XML

object ExerciseSep27XMLReading extends App {
  val srcFile = "src/resources/xml/books.xml"

  val xml = XML.loadFile(srcFile) //so val xml is points to the root element of this particular document

  //TODO create case class for the books
  //Read the books from the xml put them inside the case file, keep all the atributes and tags

  //TODO print the book objects(created from case class) in Ascending order of prices
  val bookNodes = xml \ "book" // we get some sequence of nodes

  def nodeToBook(node: scala.xml.Node):Book = {
    val category: String = node.attribute("category").getOrElse("No category").toString
    val title: String = (node \ "title").text
    val author: String  = (node \ "author").text
    val year:String = (node \ "year").text
    val price: Double = (node \ "price").text.toDouble
    Book(category, title, author, year, price)
  }

  val books = bookNodes.map(nodeToBook) //so map is our loop
  //of course we could do it with for (book <- bookNodes) yield nodeToBook(book)
  books.sortBy(_.price).foreach(println)

}
