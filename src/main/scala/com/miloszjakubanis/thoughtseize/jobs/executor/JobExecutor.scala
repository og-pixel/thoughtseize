package com.miloszjakubanis.thoughtseize.jobs.executor

import scala.collection.Iterable
import scala.collection.mutable.ArraySeq

import com.miloszjakubanis.thoughtseize.jobs.{Job, SimpleJob}
import java.util.concurrent.Executors
import scala.collection.mutable.ArrayBuffer
import com.miloszjakubanis.thoughtseize.storage.cache.Cache

trait JobExecutor(private val workerCount: Int):

  private val jobExecutionLimit: Long = 1000
  private val maximumWorkingThreads = 1

  protected[jobs] val executorService = Executors.newFixedThreadPool(workerCount).nn

  def shutdown(): Unit = executorService.shutdown()
  def shutdownNow(): Unit = executorService.shutdownNow()

  //TODO return type
  def addJob(job: Job[_, _]): Unit = 
    executorService.submit(job)