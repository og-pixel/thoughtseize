package com.miloszjakubanis.thoughtseize.jobs


trait Job[In, Out] extends Thread:

  val function: (In => Out)
  val timeLimit: Long = 100
  var jobState: JobState = JobState.PREPARING

  val results: Seq[Out]
  val repeat: Boolean

  def run(): Unit

  def executeJob: Out