package com.miloszjakubanis.thoughtseize.jobs

import scala.collection.mutable.ArrayBuffer

import scala.reflect.ClassTag
import com.miloszjakubanis.thoughtseize.storage.cache.{SimpleCache, Cache}


class SimpleJob[In, Out](val content: In, index: Long, val function: (In => Out), storage: Cache[Out]) extends StorageJob[In, Out](storage):

  private[this] var executionTime: Option[Int] = Option.empty

  override def run(): Unit = 
    val start: Long = System.currentTimeMillis
    val result = function(content)

    storage.write(result, index)
    // storage ++= result
    // storage += result
    executionTime = Option(((System.currentTimeMillis - start) / 1000000).toInt)