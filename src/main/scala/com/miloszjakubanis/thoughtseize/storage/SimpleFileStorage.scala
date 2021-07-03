package com.miloszjakubanis.thoughtseize.storage

import com.miloszjakubanis.thoughtseize.id.factory.IDFactory
import com.miloszjakubanis.thoughtseize.id.ID
import com.miloszjakubanis.thoughtseize.storage.Storage
import com.miloszjakubanis.thoughtseize.location.Location
import com.miloszjakubanis.thoughtseize.jobs.executor.{JobExecutor, SimpleJobExecutor}

import java.io.File
import scala.collection.mutable.HashMap
import java.nio.file.Files
import java.nio.file.Path
import java.nio.file.StandardOpenOption
import com.miloszjakubanis.thoughtseize.jobs.PrintingJob

/**
  * One singular folder holding files inside, no nesting
  * Depends on a lock to keep everything in right order
  */
class SimpleFileStorage(
  val id: ID,
  val storageName: String,
  val location: Location[_],
  val workerCount: Int,
) extends AbstractFileStorage[Array[Byte], Long]:

  // val executor: JobExecutor = 
  //   SimpleJobExecutor(workerCount)

  override def write(content: Array[Byte], index: Long): Option[Array[Byte]] = 
    if keyStorageFileExists(index) 
    then 
      Files.write(storagePath.resolve(index.toString), content)
      Option(content)
    else 
      val file = Files.createFile(storagePath.resolve(index.toString))
      Files.write(storagePath.resolve(index.toString), content)
      Option(content)

  override def append(content: Array[Byte], index: Long): Option[Array[Byte]] = 
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
