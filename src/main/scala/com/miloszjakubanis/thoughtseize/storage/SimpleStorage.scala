package com.miloszjakubanis.thoughtseize.storage

import com.miloszjakubanis.thoughtseize.id.factory.IDFactory
import com.miloszjakubanis.thoughtseize.id.ID
import com.miloszjakubanis.thoughtseize.storage.Storage
import com.miloszjakubanis.thoughtseize.location.Location

import java.io.File
import scala.collection.mutable.HashMap
import java.nio.file.Files
import java.nio.file.Path
import java.nio.file.StandardOpenOption

/**
  * One singular folder holding files inside, no nesting
  * Depends on a lock to keep everything in right order
  */
class SimpleStorage(
  val id: ID,
  val storageName: String,
  val location: Location[_],
) extends AbstractFileStorage[Array[Byte], Long]:

  def write(content: Array[Byte], index: Long): Option[Array[Byte]] = 
    if keyStorageFileExists(index) 
    then 
      Files.write(storagePath.resolve(index.toString), content)
      Option(content)
    else 
      val file = Files.createFile(storagePath.resolve(index.toString))
      Files.write(storagePath.resolve(index.toString), content)
      Option(content)

  def append(content: Array[Byte], index: Long): Option[Array[Byte]] = 
    if keyStorageFileExists(index) 
    then 
      Files.write(storagePath.resolve(index.toString), content, StandardOpenOption.APPEND)
      Option(content)
    else 
      val file = Files.createFile(storagePath.resolve(index.toString))
      Files.write(storagePath.resolve(index.toString), content, StandardOpenOption.APPEND)
      Option(content)

  private[storage] def keyStorageFileExists(key: Long): Boolean = 
    Files.exists(storagePath.resolve(key.toString))