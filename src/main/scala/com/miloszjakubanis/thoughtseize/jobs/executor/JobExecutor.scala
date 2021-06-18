package com.miloszjakubanis.thoughtseize.jobs.executor

import scala.collection.Iterable
import scala.collection.mutable.ArraySeq

import com.miloszjakubanis.thoughtseize.jobs.{Job, SimpleJob}

trait JobExecutor[Storage <: Iterable[Job[_, _]]]:
  val storage: Storage

class A extends JobExecutor[ArraySeq[Job[_, _]]]:
  val storage: ArraySeq[Job[_, _]] = ArraySeq(new SimpleJob())
