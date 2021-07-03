package com.miloszjakubanis.thoughtseize.location

import com.miloszjakubanis.thoughtseize.storage.FileStorage
import com.miloszjakubanis.thoughtseize.storage.factory.StorageFactory
import com.miloszjakubanis.thoughtseize.storage.factory.SimpleStorageFactory
import com.miloszjakubanis.thoughtseize.storage.SimpleFileStorage
import com.miloszjakubanis.thoughtseize.id.factory.IDFactory
import com.miloszjakubanis.thoughtseize.id.factory.SimpleIDFactory

class SimpleLocationStrategy(
  folderName: String = ".filesystem",
  workerCount: Int
  ) extends Location[SimpleFileStorage](folderName):

  lazy val storageFactory: StorageFactory[SimpleFileStorage] = 
    SimpleStorageFactory(this)

  lazy val storage: SimpleFileStorage = 
    val id = idFactory.nextID
    SimpleFileStorage(id, id.toString, this, workerCount)

  