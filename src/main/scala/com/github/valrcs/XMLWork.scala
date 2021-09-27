package com.github.valrcs

import scala.xml.XML

object XMLWork extends App {
  val srcFile = "src/resources/xml/books.xml"

  val xml = XML.loadFile(srcFile) //so val xml is points to the root element of this particular document

  println(xml)

  val books = xml \ "book" // we get some sequence of nodes
//  print(books)

  for (book <- books) {
    val category = book.attribute("category").getOrElse("No category") //we might not have a category right ?
    val author = book \ "author" //so potentiall we could have multiple author tags here
    val title = book \ "title"
    val price = (book \ "price").text.toDouble // price could have . in it right...

    println(s"Book: ${title.text} written by ${author.text} priced at $price in category: $category")
  }
}
