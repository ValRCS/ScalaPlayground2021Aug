package com.github.valrcs

/**
 * Utilities collects our commonly uses utilities across the whole project
 */
object Utilities {
  val MYP = 3.1415926
  def add(a:Int, b:Int): Int = a+b //functions that are to be used by others should have full type information
  //if we forget Intellij will remind us at some point
}
