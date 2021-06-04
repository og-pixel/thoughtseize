package com.miloszjakubanis.thoughtseize

import java.nio.file.Paths
import com.typesafe.config.ConfigFactory
import com.miloszjakubanis.thoughtseize.location.LocationStrategy
import com.miloszjakubanis.thoughtseize.ConfigValues

@main def hello =
  println(ConfigValues("config.location"))
  println(ConfigValues("config.user"))
  