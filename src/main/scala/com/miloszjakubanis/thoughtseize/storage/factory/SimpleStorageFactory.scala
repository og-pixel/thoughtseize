package com.miloszjakubanis.thoughtseize.storage.factory

import com.miloszjakubanis.thoughtseize.storage.{Storage, SimpleFileStorage}
import com.miloszjakubanis.thoughtseize.id.factory.{IDFactory, SimpleIDFactory}
import com.miloszjakubanis.thoughtseize.id.factory.IDFactory
import com.miloszjakubanis.thoughtseize.id.ID
import com.miloszjakubanis.thoughtseize.location.Location
import scala.collection.mutable

class SimpleStorageFactory(val location: Location[_]) extends StorageFactory[SimpleFileStorage]:

  private[this] val idFactory: IDFactory = SimpleIDFactory()

  val map = mutable.HashMap[ID, String]()

  def silo(workerCount: Int): SimpleFileStorage = 
    val id = idFactory.nextID
    SimpleFileStorage(id, id.toString, location, workerCount)