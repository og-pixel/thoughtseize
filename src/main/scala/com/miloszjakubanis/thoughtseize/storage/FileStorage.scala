package com.miloszjakubanis.thoughtseize.storage

import com.miloszjakubanis.thoughtseize.location.Location
import com.miloszjakubanis.thoughtseize.storage.cache.Cache
import com.miloszjakubanis.thoughtseize.storage.cache.SimpleCache
import java.nio.file.Files
import java.nio.file.Path
import com.miloszjakubanis.thoughtseize.jobs.executor.JobExecutor

trait FileStorage[T2, T3 <: Long | String] extends Storage[T2, T3]:

  val storageName: String
  val location: Location[_]
  val storagePath: Path = location.asPath.resolve(storageName).nn

  //TOOD make sure it is T2 that I want as a parameter
  val cache: Cache[_] = SimpleCache[T2]()

  //TODO remove, will be in User trait
  // val executor: JobExecutor

  private[storage] def createStorageLocation(): Boolean = 
    Files.createDirectories(storagePath) != null

  private[storage] def storageLocationExists: Boolean =
    Files.exists(storagePath)

  // private[storage] def keyStorageFileExists(key: T3): Boolean = 
  //   storage

  private[storage] def createStorageFile(key: T3): Boolean = 
    key match 
      case l: Long => Files.createFile(location.asPath.resolve(l.toString)) != null
      case s: String => Files.createFile(location.asPath.resolve(s)) != null

  private[storage] def fileExists(path: Path): Boolean = Files.exists(path)

  // def start: Unit =
  //   executor.start()