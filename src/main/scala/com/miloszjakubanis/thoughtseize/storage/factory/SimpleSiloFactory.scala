package com.miloszjakubanis.thoughtseize.storage.factory

import com.miloszjakubanis.thoughtseize.storage.{Storage, SimpleStorage}
import com.miloszjakubanis.thoughtseize.id.factory.{IDFactory, SimpleIDFactory}
import com.miloszjakubanis.thoughtseize.id.factory.IDFactory
import com.miloszjakubanis.thoughtseize.id.ID
import scala.collection.mutable

class SimpleSiloFactory extends SiloFactory[SimpleStorage]:

  private[this] val idFactory: IDFactory = SimpleIDFactory()

  val map = mutable.HashMap[ID, String]()

  def silo(): SimpleStorage = 
    val id = idFactory.nextID()
    SimpleStorage(id, id.toString)