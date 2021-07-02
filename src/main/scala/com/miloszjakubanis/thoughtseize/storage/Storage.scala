package com.miloszjakubanis.thoughtseize.storage

import java.nio.file.Path
import java.nio.file.Files
import scala.collection.mutable.ArrayBuffer
import com.miloszjakubanis.thoughtseize.jobs.Job

trait Storage[T2, T3 <: Long | String]:

  def write(content: T2, index: T3): Option[T2]
  def append(content: T2, index: T3): Option[T2]

  // val list = ArrayBuffer[Job[_,_]]()