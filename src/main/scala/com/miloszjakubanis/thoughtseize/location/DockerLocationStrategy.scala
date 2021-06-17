package com.miloszjakubanis.thoughtseize.location

import com.miloszjakubanis.thoughtseize.storage.SimpleStorage
import com.miloszjakubanis.thoughtseize.storage.factory.{StorageFactory, SimpleStorageFactory}
import com.miloszjakubanis.thoughtseize.storage.Storage

class DockerLocationStrategy(folderName: String = "filesystem") extends Location[SimpleStorage](folderName):

  lazy val storageFactory: StorageFactory[SimpleStorage] = new SimpleStorageFactory(this) //TODO work on new/apply

  override lazy val location: String = s"/$folderName"
  override lazy val storage: SimpleStorage = storageFactory.silo()