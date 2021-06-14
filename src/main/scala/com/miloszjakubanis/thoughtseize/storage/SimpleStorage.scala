package com.miloszjakubanis.thoughtseize.storage

import com.miloszjakubanis.thoughtseize.id.factory.IDFactory
import com.miloszjakubanis.thoughtseize.id.ID
import com.miloszjakubanis.thoughtseize.storage.Storage

import java.io.File
import scala.collection.mutable

/**
  * One singular folder holding files inside, no nesting
  * Depends on a lock to keep everything in right order
  */
class SimpleStorage(
  val id: ID,
  val siloName: String,
) extends Storage[String, File]:

  // var lock: String = ""
  // var isLocked: Boolean = false
  private[this] val children: mutable.HashMap[String, File] = mutable.HashMap()
  def getSiloContent(key: String): File = children(key)
