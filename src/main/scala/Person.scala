case class Person(name: String, relation: String, var topSpeed:Int)
//so case class creates some fields automatically, val by default, var needs to be specified
//less typing
//supports pattern matching more about that later
//pretty print build in

//we often use case classes for things like single rows in some database that translates really well

object CreatingPersons extends App {
  val me = Person("valdis", "myself", 180) //notice that we do not need new anymore saves some typing :)
  println(me) //case classes have prebuilt pretty print
  val edith = Person("ede", "daughter", 300)
  println(edith)
  edith.topSpeed = 500
//  edith.relation = "cant" //it is val so immutable
  println(edith)
}
