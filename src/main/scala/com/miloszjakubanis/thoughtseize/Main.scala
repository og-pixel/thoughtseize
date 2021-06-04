package com.miloszjakubanis.thoughtseize

import java.nio.file.Paths
import com.typesafe.config.ConfigFactory
import com.miloszjakubanis.thoughtseize.location.Location
import com.miloszjakubanis.thoughtseize.ConfigValues

@main def hello =
  // println(ConfigValues("config.location"))
  // println(ConfigValues("config.user"))

  val location = Location(ConfigValues("config.location"))
  println(location.location)
