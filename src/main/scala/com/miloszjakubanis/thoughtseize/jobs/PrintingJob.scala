package com.miloszjakubanis.thoughtseize.jobs

import scala.collection.mutable.ArraySeq
import com.miloszjakubanis.thoughtseize.jobs.factory.SimpleJobFactory

class PrintingJob(val content: String, val repeat: Boolean = false) extends Job[String, Unit]:

  val function: (String => Unit) = println(_)
  val results: Seq[Unit] = Seq()

  def executeJob: Unit = 
    println(s"started: ${this.toString}")
    Thread.sleep(2000)
    function(content)

//   override def run(): Unit = executeJob