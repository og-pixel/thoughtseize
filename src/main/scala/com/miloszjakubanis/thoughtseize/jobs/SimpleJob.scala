package com.miloszjakubanis.thoughtseize.jobs

import scala.collection.mutable.ArrayBuffer

import scala.reflect.ClassTag
import com.miloszjakubanis.thoughtseize.storage.cache.SimpleCache


class SimpleJob[In, Out](val content: In, val function: (In => Out), val storage: ArrayBuffer[Out]) extends Job[In, Out]:

  private[this] var executionTime: Option[Int] = Option.empty

  override def run(): Unit = 
    val start: Long = System.currentTimeMillis
    val result = function(content)
    storage += result
    executionTime = Option(((System.currentTimeMillis - start) / 1000000).toInt)