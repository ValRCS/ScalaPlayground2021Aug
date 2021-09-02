object FunctionalStyle extends App {
  var total = 0
  def addToTotal(n:Int)= total += n //this is a bad style because it has side effects

  //much better to have PURE function , meaning it does not modify anything outside its own values
  //preferably it returns something, exception would be printing functions
  def add(a:Int, b:Int) = a+b
  total = add(total, 5)

  def addWithPrint(a:Int, b:Int) = println(a+b) //this is just a very specific prnting function
}
