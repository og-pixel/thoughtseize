package com.miloszjakubanis.thoughtseize

import java.nio.file.Paths
import com.typesafe.config.ConfigFactory
import com.miloszjakubanis.thoughtseize.config.DefaultConfig
import scala.sys.ShutdownHookThread
import scala.concurrent.Future
import java.net.URL
import com.miloszjakubanis.thoughtseize.storage.{Database, FSDatabase, Location}
import java.nio.file.{Path, Paths}

@main def hello =
  val a: Database = new FSDatabase(Location("hello"))
  a.writeBytes("hello-space2", "ID", "hello world!")