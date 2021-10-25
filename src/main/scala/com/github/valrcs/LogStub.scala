package com.github.valrcs

import com.typesafe.scalalogging.Logger

//so this is a singleton object without main
object LogStub {
  val logger: Logger = Logger("name of my log")
}
