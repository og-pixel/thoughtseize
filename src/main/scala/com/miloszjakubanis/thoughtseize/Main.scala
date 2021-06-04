package com.miloszjakubanis.thoughtseize

import java.nio.file.Paths
import com.typesafe.config.ConfigFactory
import com.miloszjakubanis.thoughtseize.location.LocationStrategy
import com.miloszjakubanis.thoughtseize.defaults.CONFIG_DEFAULTS

@main def hello =
  println()
  // val conf = ConfigFactory.load().nn

  // val confLocation = conf.getString("config.location") match 
  //   case a: String => a
  //   case _ => DEFAULT_LOCATION

  // val location = LocationStrategy.getLocationStrategy(confLocation)