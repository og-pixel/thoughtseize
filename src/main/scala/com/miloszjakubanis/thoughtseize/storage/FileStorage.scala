package com.miloszjakubanis.thoughtseize.storage

import com.miloszjakubanis.thoughtseize.location.Location
import com.miloszjakubanis.thoughtseize.storage.cache.Cache
import com.miloszjakubanis.thoughtseize.silo.cache.SimpleCache
import java.nio.file.Files
import java.nio.file.Path

trait FileStorage[T, T2, T3 <: Long | String] extends Storage[T, T2, T3]:

  val storageName: String
  val location: Location[_]
  val storagePath: Path = location.asPath.resolve(storageName).nn

  val cache: Cache[_, _, _] = SimpleCache()


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