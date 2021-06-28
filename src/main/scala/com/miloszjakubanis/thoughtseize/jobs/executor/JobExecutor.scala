package com.miloszjakubanis.thoughtseize.jobs.executor

import scala.collection.Iterable
import scala.collection.mutable.ArraySeq

import com.miloszjakubanis.thoughtseize.jobs.{Job, SimpleJob}
import java.util.concurrent.Executors

trait JobExecutor extends Runnable:

  val jobExecutionLimit: Long = 1000
  val workerCount: Int = 5
  val executorService = Executors.newFixedThreadPool(workerCount)

  val storage: Iterable[Job[_, _]]

  def apply(): Unit = ???