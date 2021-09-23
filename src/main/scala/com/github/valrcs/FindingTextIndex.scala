package com.github.valrcs

object FindingTextIndex extends App {

    val src = "src/resources/two_roads.txt"
    val lines = Utilities.getLinesFromFile(src)
    val roads = lines.filter(_.contains("road"))
    val indexes = lines.zipWithIndex.filter(_._1.contains("roads")).map(_._2)
    roads.foreach(println)

    indexes.foreach(println)

    val triples = lines.lazyZip(lines.slice(1,lines.length)).lazyZip(lines.slice(2, lines.length)).toArray

    triples.foreach(println)


    val quads = "kartupelis".lazyZip(Range(0,15)).lazyZip((40 to 16 by -2)).lazyZip(Array("kafe","art","rome","tokyo")).toArray
    println(quads.size) //should be 4 because that is the shortest of sequences
    quads.foreach(println)

    //of course if you go through lines with index you can inspect using that index just careful of not inspecting lines below 0 or
  //or longer than lines.lenght-1
    println(lines.last, lines(lines.length-1))
//    println(lines(lines.length)) //Array out of bounds


}
