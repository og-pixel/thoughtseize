package com.miloszjakubanis.thoughtseize.jobs

trait Job[In, Out]:
  def executeJob(in: In): Out
  def apply(in: In): Out = executeJob(in)

class SimpleJob extends Job[String, Unit]:
  def executeJob(in: String): Unit = println(in)