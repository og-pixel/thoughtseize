package com.miloszjakubanis.thoughtseize

import java.nio.file.Paths
import com.typesafe.config.ConfigFactory
import com.miloszjakubanis.thoughtseize.location.Location
import com.miloszjakubanis.thoughtseize.config.DefaultConfig
import com.miloszjakubanis.thoughtseize.location.SimpleLocationStrategy

given Conversion[String, Array[Byte]] with
  def apply(s: String): Array[Byte] = s.getBytes.nn

@main def hello =
  // println(ConfigValues("config.location"))
  // println(ConfigValues("config.user"))

  val location = Location(DefaultConfig("config.location")).asInstanceOf[SimpleLocationStrategy]
  println(location.location)
  val arr: Array[Byte] = "Hello world!".getBytes.nn
  
  location.storage.write("dasdasd", 2)
