package com.github.valrcs

object ExtractEmail extends App {
  val srcFile = "src/resources/final_project_participants.txt"
  val lines = Utilities.getLinesFromFile(srcFile)
  println(lines.size)

  //here we did not need it since we had an easy split but if  your emails are hiding then we need more powerful toosl

  //https://alvinalexander.com/scala/how-to-extract-parts-strings-match-regular-expression-regex-scala/
  //fully compliant regex for email is crazily long
  //https://stackoverflow.com/questions/201323/how-can-i-validate-an-email-address-using-a-regular-expression
  //since there are lots of extra case

  val emailRegEx = ".* (\\S+@\\S+\\.\\S+).*".r
  //so we match every character until space then what we want is
  // (some NON whitespace @ some NON whitespace . some NON Whitespace )
  //end with anything or nothing
  println(lines.head)

  //we can pattern match multiple regex expression here
  lines.head match {
    case emailRegEx(email) => println(s"We got e-mail $email")
//    case MoviesNearCityStateRE(city, state) => getSearchResults(city, state)
    case _ => println("did not match a regex")
  }

  lines.last match {
    case emailRegEx(email) => println(s"We got e-mail $email")
    //    case MoviesNearCityStateRE(city, state) => getSearchResults(city, state)
    case _ => println("did not match a regex")
  }

}
