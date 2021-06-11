package com.miloszjakubanis.thoughtseize.silo

import com.miloszjakubanis.thoughtseize.id.factory.IDFactory
import com.miloszjakubanis.thoughtseize.id.ID
import com.miloszjakubanis.thoughtseize.silo.Silo

import java.io.File
import scala.collection.mutable
import java.nio.file.Path

/**
  * One singular folder holding files inside, no nesting
  * Depends on a lock to keep everything in right order
  */
class SimpleSilo(
  val id: ID,
  val location: Path,
  private[this] val siloName: String,
) extends Silo[ID, File]:

  // var lock: String = ""
  // var isLocked: Boolean = false
  private[this] val children: mutable.HashMap[ID, File] = mutable.HashMap()
  def getSiloContent(key: ID): File = children(key)
  
  def put(key: ID, value: File): Option[File] = 
    children.put(key, value)

  def remove(key: ID): Option[File] = ???