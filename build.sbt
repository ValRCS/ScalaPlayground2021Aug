name := "ScalaPlayground2021Aug"

version := "0.1"

scalaVersion := "2.13.6"

// https://mvnrepository.com/artifact/com.lihaoyi/upickle
libraryDependencies += "com.lihaoyi" %% "upickle" % "1.4.1"
//i am saying I want this library included in my project above

//so I do ned to add XML library even thought it is made by Scala team
//They decided to split if from main Scala, partially because it is not always needed

// https://mvnrepository.com/artifact/org.scala-lang.modules/scala-xml
libraryDependencies += "org.scala-lang.modules" %% "scala-xml" % "2.0.1"

// https://mvnrepository.com/artifact/org.yaml/snakeyaml
libraryDependencies += "org.yaml" % "snakeyaml" % "1.29"

//not very active but still useful if you to read Windows .ini files
// https://mvnrepository.com/artifact/org.ini4j/ini4j
libraryDependencies += "org.ini4j" % "ini4j" % "0.5.4"

// https://mvnrepository.com/artifact/org.xerial/sqlite-jdbc
libraryDependencies += "org.xerial" % "sqlite-jdbc" % "3.36.0.3"

// https://mvnrepository.com/artifact/org.scalatest/scalatest
libraryDependencies += "org.scalatest" %% "scalatest" % "3.2.10" % Test

// https://mvnrepository.com/artifact/org.slf4j/slf4j-simple
//libraryDependencies += "org.slf4j" % "slf4j-simple" % "1.7.32" % Test
//libraryDependencies += "org.slf4j" % "slf4j-simple" % "1.7.32"


// https://mvnrepository.com/artifact/ch.qos.logback/logback-classic
//libraryDependencies += "ch.qos.logback" % "logback-classic" % "1.2.6" % Test
libraryDependencies += "ch.qos.logback" % "logback-classic" % "1.2.6"

// https://mvnrepository.com/artifact/com.typesafe.scala-logging/scala-logging
libraryDependencies += "com.typesafe.scala-logging" %% "scala-logging" % "3.9.4"



