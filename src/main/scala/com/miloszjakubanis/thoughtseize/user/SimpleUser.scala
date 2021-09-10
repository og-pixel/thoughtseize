package com.miloszjakubanis.thoughtseize.user

import com.miloszjakubanis.thoughtseize.id.ID
import com.miloszjakubanis.thoughtseize.jobs.executor.{JobExecutor, SimpleJobExecutor}

class SimpleUser(
  val userId: ID,
  val userName: String,
  val workerCount: Int = 3,
) extends User:

  val jobExecutor: JobExecutor = SimpleJobExecutor(workerCount)