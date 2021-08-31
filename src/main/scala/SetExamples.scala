object SetExamples extends App {
  println("The Scala Set class is an iterable collection with no duplicate elements.")

  val mySet = Set(0,1,2,3,5,6,6,7,7,2,1,13,-5,-8,-5)
  println(mySet)
  val myUniqueNumberArray = mySet.toArray.sorted
  println(myUniqueNumberArray.mkString(","))

  //so if you have an Array of duplicates you can cast it to set then back to Array
  //and voila! all the duplicates are gone
  val a = Array(0,3,2,6,1,6,6,2,6,1,2,6,7,8,8)
  val s = a.toSet
  val uniqueArr = s.toArray
  println(a.mkString(","))
  println(s.mkString(",")) //so set does not have a specific order
  println(uniqueArr.mkString(","))

  //https://docs.scala-lang.org/overviews/scala-book/set-class.html

  val set = scala.collection.mutable.Set[Int]() //so empty mutable set we can add and remove items
  println(set)
  set += 1
  println(set)
  set += 2 += 3
  println(set)
  set ++= Vector(4, 5)
  println(set)
  set ++= Array(4, 5,7,9,3,2) //here only the not yet added numbers will be added to set
  println(set)
  set ++= Array(-6,-3,-3,100, 90, 89,95, 1)
  println(set)
  //Set also has an add method that returns true if an element is added to a set,
  // and false if it wasn’t added.
  val is_6_added = set.add(6)
  val is_7_added = set.add(7)
  println(is_6_added,is_7_added)
  println(set)

  println(s"My set is ${set.size} items long")

  //deletion
  set -= 3
  println(set)
  set --= Array(2,6,6)
  println(set)

  set.clear()
  println(set)

  //we can also get booleans on our removal of items using set.remove
  val is_6_removed = set.remove(6) //this should be false, since we are removing 6 from empty set!
  println(is_6_removed)

  val n1to5 = (1 to 5).toSet
  val n3to7 = (3 to 7).toSet
  println(n1to5)
  println(n3to7)

  //with intersection we are saying we want elements common to both sets
  val n3to5 = n1to5 intersect n3to7
  val n3to5also = n1to5 & n3to7 //same as above intersect //notice we are using single & not &&
  println(n3to5)
  println(n3to5also)

  //we can also perform union, which means we get all unique elements across both sets
  val n1to7 = n1to5 union n3to7
  val n1to7also = n1to5 | n3to7
  println(n1to7)
  println(n1to7also)

  //unsymmetrical difference meaning we want everything that is in the left side that is unique to left
  //order matters here!!
  val n1to2 = n1to5 diff n3to7 //also &~ could be used instead of diff
  val n6to7 = n3to7 diff n1to5
  println(n1to2)
  println(n6to7)

  //You can iterate over Sets using for-loops, but the order of items is undefined and should not be relied
  //upon:
  for (n <- n1to7) println(n)

  //sets are going to be faster than sequence for checking whether element is in the set
  println(n1to7 contains 3)
  println(n1to7 contains 53)

  val contains_78 = n1to7 contains 78
  println(s"Set ${n1to7} contains 78: ${contains_78}")

  val numberToCheck = 567
  val containsNumber = n1to7 contains numberToCheck
  println(s"Set ${n1to7} contains $numberToCheck: ${containsNumber}")

  val myName = "Valdis"
  val myDrink = "Alus"
  val myLetters = myName.toSet
  val drinkLetters = myDrink.toSet
  println(myLetters, drinkLetters)

  val commonLetters = myLetters intersect drinkLetters
  println(commonLetters)

  val commonLowercase = myName.toLowerCase.toSet intersect myDrink.toLowerCase.toSet
  println(commonLowercase)

  val text = "See Spot run. Run, Spot. Run!"
  val words = text.split("[ !,.]+") //we can split not only on whitespace but many different characters at once
  println(words.mkString("::"))

  val wordSet = scala.collection.mutable.Set.empty[String]

  for (word <- words) wordSet += word.toLowerCase

  println(wordSet)

  println(n1to2.subsetOf(n1to7)) //true
}
