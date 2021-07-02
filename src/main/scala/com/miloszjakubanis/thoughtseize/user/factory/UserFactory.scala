package com.miloszjakubanis.thoughtseize.user.factory

import com.miloszjakubanis.thoughtseize.id.factory.IDFactory
import com.miloszjakubanis.thoughtseize.id.factory.SimpleIDFactory
import com.miloszjakubanis.thoughtseize.user.User
import com.miloszjakubanis.thoughtseize.jobs.executor.JobExecutor

trait UserFactory:
  val idFactory: IDFactory = SimpleIDFactory()
  def nextUser(userName: String, jobExecutor: JobExecutor): User