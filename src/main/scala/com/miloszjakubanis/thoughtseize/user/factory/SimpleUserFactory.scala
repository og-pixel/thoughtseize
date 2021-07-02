package com.miloszjakubanis.thoughtseize.user.factory

import com.miloszjakubanis.thoughtseize.user.{User, SimpleUser}
import com.miloszjakubanis.thoughtseize.jobs.executor.JobExecutor

class SimpleUserFactory extends UserFactory:

  def nextUser(userName: String): User = 
    SimpleUser(idFactory.nextID, userName)