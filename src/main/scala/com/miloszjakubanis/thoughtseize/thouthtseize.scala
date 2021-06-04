package com.miloszjakubanis.thoughtseize

import com.typesafe.config.ConfigFactory
import com.miloszjakubanis.thoughtseize.ConfigLoader
import com.miloszjakubanis.thoughtseize.location.LocationStrategy
import scala.collection.immutable

type ID = Long

package defaults {


  val CONFIG_DEFAULTS = immutable.HashMap[String, String](
    "config.location" -> "filesystem",
    "config.location.docker" -> "docker",
  )

  // val USER_DEFAULTS = immutable.HashMap[String, String](
  //   "a" -> "asda",
  //   "b" -> "asda",
  //   "c" -> "asda",
  // )

  val conf = ConfigFactory.load().nn

  val confLocation = conf.getString("config.location") match 
    case a: String => a
    case _ => CONFIG_DEFAULTS("config.location")

  val location = LocationStrategy.getLocationStrategy(confLocation)
}