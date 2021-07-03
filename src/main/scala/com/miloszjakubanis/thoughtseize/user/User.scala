package com.miloszjakubanis.thoughtseize.user

import com.miloszjakubanis.thoughtseize.id.ID
import com.miloszjakubanis.thoughtseize.jobs.Job
import scala.collection.mutable.ArrayBuffer
import com.miloszjakubanis.thoughtseize.jobs.executor.JobExecutor
trait User:
  val userId: ID
  val userName: String
  val jobExecutor: JobExecutor