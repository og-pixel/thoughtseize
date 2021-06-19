package com.miloszjakubanis.thoughtseize.jobs.executor

import scala.collection.Iterable
import scala.collection.mutable.ArraySeq

import com.miloszjakubanis.thoughtseize.jobs.{Job, SimpleJob}

trait JobExecutor extends Runnable:

  val jobExecutionLimit: Long = 1000

  val storage: Iterable[Job[_, _]]