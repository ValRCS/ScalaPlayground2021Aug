object WhileLoops extends App {
  println("Alice did")
  println("talk")
  println("talk")
  println("talk")
  //what to do if we want to run "talk" say 50 times? It would be silly to paste above line 50 times
  var i = 0
  //so while loops run while the condition in parenthesis below is true
  while (i < 10) {
    println(s"talking when i is $i")
    //we need to do one more thing if we want to exit this loop...
    i = i + 1 //increment the counter
  }

  //there is room for forever loops in some application
}
