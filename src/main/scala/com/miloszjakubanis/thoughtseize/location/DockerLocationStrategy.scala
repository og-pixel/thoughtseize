package com.miloszjakubanis.thoughtseize.location

import com.miloszjakubanis.thoughtseize.storage.SimpleStorage
import com.miloszjakubanis.thoughtseize.storage.factory.{StorageFactory, SimpleStorageFactory}
import com.miloszjakubanis.thoughtseize.storage.Storage

class DockerLocationStrategy(workerCount: Int) extends Location[SimpleStorage]("filesystem"):

  lazy val storageFactory: StorageFactory[SimpleStorage] = new SimpleStorageFactory(this) //TODO work on new/apply

  override lazy val location: String = s"/$local"
  override lazy val storage: SimpleStorage = storageFactory.silo(workerCount)