package com.miloszjakubanis.thoughtseize.jobs.executor

import scala.collection.mutable.ArraySeq
import com.miloszjakubanis.thoughtseize.jobs.{Job, SimpleJob}
import scala.collection.mutable.ArrayBuffer

class SimpleJobExecutor() extends JobExecutor:

  val storage: ArrayBuffer[Job[_, _]] = ArrayBuffer()

  override def run(): Unit = 
    for (job <- storage)
      println("running job...")
      job.start()