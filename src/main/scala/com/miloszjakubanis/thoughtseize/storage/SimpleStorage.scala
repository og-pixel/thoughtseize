package com.miloszjakubanis.thoughtseize.storage

import com.miloszjakubanis.thoughtseize.id.factory.IDFactory
import com.miloszjakubanis.thoughtseize.id.ID
import com.miloszjakubanis.thoughtseize.storage.Storage
import com.miloszjakubanis.thoughtseize.location.Location

import java.io.File
import scala.collection.mutable.HashMap
import java.nio.file.Files

/**
  * One singular folder holding files inside, no nesting
  * Depends on a lock to keep everything in right order
  */
class SimpleStorage(
  val id: ID,
  val siloName: String,
  val location: Location[_],
) extends FileStorage[HashMap[String, File], Array[Byte], Long]:

  private[this] val children: HashMap[String, File] = HashMap()

  val storage: HashMap[String, File] = children

  def write(content: Array[Byte], index: Long): Option[Array[Byte]] = 
    //TODO check if file exists
    val path = location.asPath.resolve(siloName).nn
    val file = Files.createFile(path)
    Files.write(path, content)
    Option(content)
