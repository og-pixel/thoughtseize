package com.miloszjakubanis.thoughtseize.jobs

import com.miloszjakubanis.thoughtseize.jobs.factory.JobFactory
import com.miloszjakubanis.thoughtseize.jobs.factory.SimpleJobFactory


trait Job[In, Out] extends Runnable:

  val timeLimit: Long = 100
  val function: (In => Out)
  
  //TODO maybe delete
  def apply() = run()