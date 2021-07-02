package com.miloszjakubanis.thoughtseize

import java.nio.file.Paths
import com.typesafe.config.ConfigFactory
import com.miloszjakubanis.thoughtseize.location.Location
import com.miloszjakubanis.thoughtseize.config.DefaultConfig
import com.miloszjakubanis.thoughtseize.location.*
import com.miloszjakubanis.thoughtseize.jobs.{SimpleJob, PrintingJob}
import com.miloszjakubanis.thoughtseize.jobs.SendToFileJob
import com.miloszjakubanis.thoughtseize.user.User
import com.miloszjakubanis.thoughtseize.user.factory.SimpleUserFactory
import com.miloszjakubanis.thoughtseize.jobs.executor.SimpleJobExecutor

given Conversion[String, Array[Byte]] with
  def apply(s: String): Array[Byte] = s.getBytes.nn

@main def hello =
  val location = Location(
    DefaultConfig("config.location"),
    DefaultConfig("config.workers").toInt
  ).asInstanceOf[SimpleLocationStrategy]

  val factory = SimpleUserFactory()
  val user: User = factory.nextUser("jakubek278", SimpleJobExecutor())

  user.addJob(PrintingJob("Hello world - this is a printing job"))
  val result = user.addJob(PrintingJob("Hello world - Thats a second printing job"))


  Thread.sleep(4000)
  user.jobExecutor.shutdown()

  System.exit(0)