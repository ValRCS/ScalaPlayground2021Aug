package com.github.valrcs

case class Player(name: String="Player A", var win:Int=0, var loss:Int=0) {
  def getPrettyRow():String = s"$name\t$win\t$loss"
  //TODO add some padding to name so short and long names have similar appearance
}
