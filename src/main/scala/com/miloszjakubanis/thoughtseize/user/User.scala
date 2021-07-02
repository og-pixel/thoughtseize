package com.miloszjakubanis.thoughtseize.user

import com.miloszjakubanis.thoughtseize.id.ID
import com.miloszjakubanis.thoughtseize.jobs.Job
import scala.collection.mutable.ArrayBuffer
import com.miloszjakubanis.thoughtseize.jobs.executor.JobExecutor

trait User:
  val userId: ID
  val userName: String
  val jobExecutor: JobExecutor

  //TODO improve return type
  def addJob(job: Job[_, _]): Seq[_] = 
    jobExecutor.addJob(job)


  //TODO means to run from the start
  def start: Unit = ???
  def shutdown: Unit = ???
  def shutdownNow: Unit = ???
