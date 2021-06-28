package com.miloszjakubanis.thoughtseize.jobs


trait Job[In, Out] extends Runnable:

  val function: (In => Out)
  val timeLimit: Long = 100
  var jobState: JobState = JobState.PREPARING

  val results: Seq[Out]

  def run(): Unit

  def executeJob: Out