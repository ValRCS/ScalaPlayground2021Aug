package com.github.valrcs

object UsingLog extends App {
  println("Using log functionality")
  LogStub.logger.info("this info should work")
  LogStub.logger.error("critical error - you should really check this out!")
}
