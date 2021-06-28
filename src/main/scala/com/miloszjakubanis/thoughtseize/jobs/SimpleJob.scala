package com.miloszjakubanis.thoughtseize.jobs

import scala.collection.mutable.ArrayBuffer

import scala.reflect.ClassTag


class SimpleJob[In, Out](val content: In, val function: (In => Out)) extends Job[In, Out]:

  val results: Seq[Out] = Seq()
  private[this] var executionTime: Option[Int] = Option.empty

  def executeJob: Out = function(content)

  def run(): Unit = 
    val start: Long = System.currentTimeMillis
    executionTime = Option(((System.currentTimeMillis - start) / 1000000).toInt)

  def getResults: Out = results.toSeq(0)