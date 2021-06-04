package com.miloszjakubanis.thoughtseize.silo

import com.miloszjakubanis.thoughtseize.factory.IDFactory
import com.miloszjakubanis.thoughtseize.ID
import com.miloszjakubanis.thoughtseize.silo.Silo

import java.io.File
import scala.collection.mutable


/**
  * One singular folder holding files inside, no nesting
  * Depends on a lock to keep everything in right order
  */
class SimpleSilo(
  val id: ID,
  val siloName: String,
) extends Silo[String, File]:

  // var lock: String = ""
  // var isLocked: Boolean = false
  private[this] val children: mutable.HashMap[String, File] = mutable.HashMap()
  def getSiloContent(key: String): File = children(key)
