package com.github.valrcs

import com.typesafe.scalalogging.Logger
import org.slf4j.LoggerFactory

object LogTest extends App {
  println("Testing logging")

//  val parentLogger = LoggerFactory.getLogger("com.github.valrcs")
//  parentLogger.info("simple log message, we do not really need other loggers")

  val logger = Logger("name of my log")

//different levels of logging
  //https://en.wikipedia.org/wiki/Syslog
  logger.debug("Least important level for users, turn off debug in production")
  logger.info("Not very important also generally turned off in production when sent to client")
  logger.warn("This is a warning! You might want to leave this in")
  logger.error("Something is really badly wrong... i'd say these should be logged")

}
