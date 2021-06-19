package com.miloszjakubanis.thoughtseize.jobs.executor

import scala.collection.mutable.ArraySeq
import com.miloszjakubanis.thoughtseize.jobs.{Job, SimpleJob}

class SimpleJobExecutor extends JobExecutor:
  val storage: ArraySeq[Job[_, _]] = ArraySeq(SimpleJob())

  def run(): Unit = ???