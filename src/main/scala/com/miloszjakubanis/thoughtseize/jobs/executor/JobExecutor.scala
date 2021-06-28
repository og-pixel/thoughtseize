package com.miloszjakubanis.thoughtseize.jobs.executor

import scala.collection.Iterable
import scala.collection.mutable.ArraySeq

import com.miloszjakubanis.thoughtseize.jobs.{Job, SimpleJob}
import java.util.concurrent.Executors
import scala.collection.mutable.ArrayBuffer

trait JobExecutor extends Thread:

  private val jobExecutionLimit: Long = 1000

  private val workerCount: Int = 5
  private val maximumWorkingThreads = 1
  private var workingThreads = 0

  private val executorService = Executors.newFixedThreadPool(workerCount).nn

  val storage: ArrayBuffer[Job[_, _]]

  //TODO return type
  def addJob(job: Job[_, _]): Unit = storage.addOne(job)