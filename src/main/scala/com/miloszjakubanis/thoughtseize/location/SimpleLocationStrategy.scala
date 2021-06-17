package com.miloszjakubanis.thoughtseize.location

import com.miloszjakubanis.thoughtseize.storage.FileStorage
import com.miloszjakubanis.thoughtseize.storage.factory.StorageFactory
import com.miloszjakubanis.thoughtseize.storage.factory.SimpleStorageFactory
import com.miloszjakubanis.thoughtseize.storage.SimpleStorage
import com.miloszjakubanis.thoughtseize.id.factory.IDFactory
import com.miloszjakubanis.thoughtseize.id.factory.SimpleIDFactory

class SimpleLocationStrategy(
  folderName: String = ".filesystem",
  ) extends Location[SimpleStorage](folderName):

  lazy val storageFactory: StorageFactory[SimpleStorage] = SimpleStorageFactory(this)
  lazy val storage: SimpleStorage = 
    val id = idFactory.nextID()
    SimpleStorage(id, id.toString, this)

  