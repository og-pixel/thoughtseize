package com.miloszjakubanis.thoughtseize.jobs.executor

import scala.collection.mutable.ArraySeq
import com.miloszjakubanis.thoughtseize.jobs.{Job, SimpleJob}
import scala.collection.mutable.ArrayBuffer
import com.miloszjakubanis.thoughtseize.storage.cache.{SimpleCache, Cache}

class SimpleJobExecutor(workerCount: Int) extends JobExecutor(workerCount):

  val cache: Cache[_, _] = SimpleCache()

  // val storage: ArrayBuffer[Job[_, _]] = ArrayBuffer()

  // override def run(): Unit = 
  //   for (job <- storage)
  //     job.start()