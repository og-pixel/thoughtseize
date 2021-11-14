package com.miloszjakubanis.thoughtseize

import java.nio.file.Paths
import com.typesafe.config.ConfigFactory
import com.miloszjakubanis.thoughtseize.config.DefaultConfig
import scala.sys.ShutdownHookThread
import scala.concurrent.Future
import java.net.URL
import com.miloszjakubanis.thoughtseize.storage.{Database, FSDatabase, Location}
import java.nio.file.{Path, Paths}
import com.miloszjakubanis.thoughtseize.storage.LocationPlace
import scala.util.Failure
import scala.util.Success

// @SerialVersionUID(123L)
class A(val name: String) extends Serializable:
  override def toString(): String = name
@main def hello =
  val a: Database = new FSDatabase(Location(".thoughtseize", LocationPlace.HOME))
