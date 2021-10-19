package com.github.valrcs

import com.typesafe.scalalogging.Logger
import org.slf4j.LoggerFactory

object LogTest extends App {
  println("Testing logging")

//  val parentLogger = LoggerFactory.getLogger("com.github.valrcs")
//  parentLogger.info("simple log message, we do not really need other loggers")

  val logger = Logger("name")


  logger.info("Hello there logging")
}
