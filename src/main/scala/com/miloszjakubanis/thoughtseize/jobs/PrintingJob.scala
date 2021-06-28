package com.miloszjakubanis.thoughtseize.jobs

import scala.collection.mutable.ArraySeq

class PrintingJob(val content: String) extends Job[String, Unit]:

  val function: (String => Unit) = println(_)

  val results: Seq[Unit] = Seq()

  def executeJob: Unit = function(content)

  def run(): Unit = ???