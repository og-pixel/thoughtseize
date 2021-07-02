package com.miloszjakubanis.thoughtseize.jobs

import com.miloszjakubanis.thoughtseize.jobs.factory.JobFactory
import com.miloszjakubanis.thoughtseize.jobs.factory.SimpleJobFactory


trait Job[In, Out] extends Thread:

  val timeLimit: Long = 100

  val function: (In => Out)
  val results: Seq[Out]

  override def run(): Unit = executeJob

  def executeJob: Out