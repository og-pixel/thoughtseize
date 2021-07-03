package com.miloszjakubanis.thoughtseize.location

import com.miloszjakubanis.thoughtseize.storage.SimpleFileStorage
import com.miloszjakubanis.thoughtseize.storage.factory.{StorageFactory, SimpleStorageFactory}
import com.miloszjakubanis.thoughtseize.storage.Storage

class DockerLocationStrategy(workerCount: Int) extends Location[SimpleFileStorage]("filesystem"):

  lazy val storageFactory: StorageFactory[SimpleFileStorage] = new SimpleStorageFactory(this) //TODO work on new/apply

  override lazy val location: String = s"/$local"
  override lazy val storage: SimpleFileStorage = storageFactory.silo(workerCount)