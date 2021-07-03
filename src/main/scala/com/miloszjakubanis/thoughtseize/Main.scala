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
import com.miloszjakubanis.thoughtseize.jobs.executor.MainJobExecutor
import com.miloszjakubanis.thoughtseize.user.SimpleUser
import scala.sys.ShutdownHookThread
import com.miloszjakubanis.thoughtseize.jobs.ShutdownJob

given Conversion[String, Array[Byte]] with
  def apply(s: String): Array[Byte] = s.getBytes.nn

@main def hello =
  val location = Location(
    DefaultConfig("config.location"),
    DefaultConfig("config.workers").toInt
  ).asInstanceOf[SimpleLocationStrategy]

  val main = MainJobExecutor(
    new SimpleUserFactory()
  )

  main.createUser("Milosz")
  Thread.sleep(1000)

  val user = main.findUser("Milosz").get

  main.submitJob(user, PrintingJob(s"Hello world from ${user.userName}"))

  main.shutdown()