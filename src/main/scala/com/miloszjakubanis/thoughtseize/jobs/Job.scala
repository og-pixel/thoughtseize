package com.miloszjakubanis.thoughtseize.jobs

import com.miloszjakubanis.thoughtseize.jobs.factory.JobFactory
import com.miloszjakubanis.thoughtseize.jobs.factory.SimpleJobFactory


trait Job[In, Out] extends Thread:

  val function: (In => Out)
  val timeLimit: Long = 100
  var jobState: JobState = JobState.PREPARING

  val results: Seq[Out]
  val repeat: Boolean

  override def run(): Unit = executeJob

  def executeJob: Out