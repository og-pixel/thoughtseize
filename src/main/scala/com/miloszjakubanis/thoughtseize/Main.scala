package com.miloszjakubanis.thoughtseize

import java.nio.file.Paths
import com.typesafe.config.ConfigFactory
import com.miloszjakubanis.thoughtseize.location.Location
import com.miloszjakubanis.thoughtseize.config.DefaultConfig
import com.miloszjakubanis.thoughtseize.location.*
import com.miloszjakubanis.thoughtseize.jobs.{SimpleJob, PrintingJob}
import com.miloszjakubanis.thoughtseize.jobs.SendToFileJob

given Conversion[String, Array[Byte]] with
  def apply(s: String): Array[Byte] = s.getBytes.nn

@main def hello =

  val location = Location(
    DefaultConfig("config.location"),
    DefaultConfig("config.workers").toInt
  ).asInstanceOf[SimpleLocationStrategy]

  for(i <- 1 to 1000)
    location.runJob(SendToFileJob(s"Hello world from job $i!\n", location.storage, 1))
    location.runJob(SendToFileJob(s"Hello world from job $i!\n", location.storage, 2))
    location.runJob(SendToFileJob(s"Hello world from job $i!\n", location.storage, 3))
    location.runJob(SendToFileJob(s"Hello world from job $i!\n", location.storage, 4))
    location.runJob(SendToFileJob(s"Hello world from job $i!\n", location.storage, 5))

  location.storage.executor.shutdown()
  location.storage.executor
