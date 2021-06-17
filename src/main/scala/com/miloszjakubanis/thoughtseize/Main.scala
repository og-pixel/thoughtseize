package com.miloszjakubanis.thoughtseize

import java.nio.file.Paths
import com.typesafe.config.ConfigFactory
import com.miloszjakubanis.thoughtseize.location.Location
import com.miloszjakubanis.thoughtseize.config.DefaultConfig
import com.miloszjakubanis.thoughtseize.location.SimpleLocationStrategy

@main def hello =
  // println(ConfigValues("config.location"))
  // println(ConfigValues("config.user"))

  val location = Location(DefaultConfig("config.location")).asInstanceOf[SimpleLocationStrategy]
  println(location.location)
  val arr: Array[Byte] = Array(23,32,11,53)
  location.storage.write(arr, 1)

 
