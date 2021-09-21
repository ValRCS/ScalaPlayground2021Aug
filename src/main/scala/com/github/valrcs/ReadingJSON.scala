package com.github.valrcs

import scala.io.Source

object ReadingJSON extends App{

  val relativePath = "./src/resources/json/employees.json"
  val bufferedSource = Source.fromFile(relativePath)
  val rawString = bufferedSource.mkString("") //we want it all in one big chunk not just by lines
  println(rawString)

  //so parsing json will require that we convert this raw string into some structure
  //so something like an Array of Maps
  val data = ujson.read(rawString)
  println(data(0)("firstName")) //we would need to add some logic here if we did not know structure ahead of time
  //I can not iterate over Value directly I need to cast it to something useful

  //since I know the outer structure is array I can cast to Scala array if I want
  val seq = data.arr.toArray
  seq.foreach(println)
  val seqObjects = seq.map(myValue => myValue.obj)
  seqObjects.foreach(println)

//  val seqScalaNative = for (obj <- seqObjects) yield {
//
//  }

  val seqScalaNative = for (obj <- seqObjects) yield {
    val sMap = for ((k,v) <- obj) yield {
//      println(s"key: $k, value: ${v.str}")
      (k, v.str)
    }
    sMap //
  }

  for (employee <- seqScalaNative) {
    println(employee)
  }

  //for even more structure we could convert our Sequence of Maps into sequence of Employees
  val arrEmployees = seq.map(value => Employee(value("firstName").str, value("lastName").str))

  arrEmployees.foreach(println)
  //so the above is great except we will fail if we have some semi broken JSON

  val fullEmployees = seqObjects.map(hashMap =>
    Employee(hashMap.getOrElse("firstName", "No first name").toString,
      hashMap.getOrElse("lastName", "No last").toString,
      hashMap.getOrElse("callSign", "001").toString
    ))
  fullEmployees.foreach(println)
}
