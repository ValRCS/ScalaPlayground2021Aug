package com.github.valrcs

case class Veggie(category:String,item:String,variety:String,date:String,price:Double,unit:String) {
  def toRow():String= s"$category,$item,$variety,$date,$price,$unit"
}
