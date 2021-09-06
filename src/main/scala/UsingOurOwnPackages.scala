import com.github.valrcs.Utilities //so whatever is in utilities i can use by using  Utilities.myfun notation
import com.github.valrcs.Utilities.{MYP, add} //{myfun, myval, etc }

object UsingOurOwnPackages extends App {
  println(Utilities.add(2,6))
  println(Utilities.MYP)
  //often a library can be quite large, we might want to use only a specific function or value
  println(MYP) //shorter but obviously we need to watch out for name collision with some other library
  //but in Scala world Intellij will tell us
  println(add(5,11))
}
