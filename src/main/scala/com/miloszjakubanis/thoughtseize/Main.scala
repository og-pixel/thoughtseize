package com.miloszjakubanis.thoughtseize

import java.nio.file.Paths
import com.typesafe.config.ConfigFactory
import com.miloszjakubanis.thoughtseize.config.DefaultConfig
import com.miloszjakubanis.thoughtseize.location.*
import com.miloszjakubanis.thoughtseize.user.User
import com.miloszjakubanis.thoughtseize.user.SimpleUser
import scala.sys.ShutdownHookThread
import scala.concurrent.Future
import java.net.URL

//import com.miloszjakubanis.`aether-vial`.AbstractJob

given Conversion[String, Array[Byte]] with
  def apply(s: String): Array[Byte] = s.getBytes.nn

@main def hello =
  println("hello world")