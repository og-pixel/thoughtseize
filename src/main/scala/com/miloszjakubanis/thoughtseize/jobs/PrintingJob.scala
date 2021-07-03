package com.miloszjakubanis.thoughtseize.jobs

import scala.collection.mutable.ArraySeq
import com.miloszjakubanis.thoughtseize.jobs.factory.SimpleJobFactory

class PrintingJob(val content: String) extends Job[String, Unit]:

  val function: (String => Unit) = println(_)
  val results: Seq[Unit] = Seq()

  override def run(): Unit = function(content)