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
