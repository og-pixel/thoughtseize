package com.miloszjakubanis.thoughtseize

import java.nio.file.Paths
import com.typesafe.config.ConfigFactory
import com.miloszjakubanis.thoughtseize.location.Location
import com.miloszjakubanis.thoughtseize.config.DefaultConfig
import com.miloszjakubanis.thoughtseize.location.*
import com.miloszjakubanis.thoughtseize.jobs.{SimpleJob, PrintingJob}

given Conversion[String, Array[Byte]] with
  def apply(s: String): Array[Byte] = s.getBytes.nn

@main def hello =
  val location = Location(DefaultConfig("config.location")).asInstanceOf[SimpleLocationStrategy]

  println(location.location)
  
  location.storage.append("hello world\n", 2)

  location.storage.executor.addJob(PrintingJob("Hello world", repeat = true))
  location.storage.executor.addJob(PrintingJob("Hello world", repeat = true))
  location.storage.executor.addJob(PrintingJob("Hello world", repeat = true))
  location.storage.executor.addJob(PrintingJob("Hello world", repeat = true))


  location.storage.executor.addJob(SimpleJob[String, Int]("2445", _.toInt))
  location.storage.start

  location.storage.executor.storage.foreach(_.join)


  println("hello world")
