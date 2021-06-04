package com.miloszjakubanis.thoughtseize.silo.factory

import com.miloszjakubanis.thoughtseize.silo.{Silo, SimpleSilo}
import com.miloszjakubanis.thoughtseize.id.factory.{IDFactory, SimpleIDFactory}
import com.miloszjakubanis.thoughtseize.id.factory.IDFactory
import com.miloszjakubanis.thoughtseize.id.ID
import scala.collection.mutable

class SimpleSiloFactory extends SiloFactory[SimpleSilo]:

  private[this] val idFactory: IDFactory = SimpleIDFactory()

  val map = mutable.HashMap[ID, String]()

  def silo(): SimpleSilo = 
    val id = idFactory.nextID()
    SimpleSilo(id, id.toString)