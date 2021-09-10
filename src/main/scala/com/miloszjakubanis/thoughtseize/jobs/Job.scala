package com.miloszjakubanis.thoughtseize.jobs

import com.miloszjakubanis.thoughtseize.jobs.factory.JobFactory
import com.miloszjakubanis.thoughtseize.jobs.factory.SimpleJobFactory


/**
 * Monad trait taking trait A and returning trait B and 
 * storing the results in a temporary storage.
 * 
 **/
trait Job[In, Out] extends Runnable:

  val timeLimit: Long = 100
  val function: (In => Out)
  
  //TODO maybe delete
  def apply() = run()

def function = print