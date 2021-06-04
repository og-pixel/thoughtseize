package com.miloszjakubanis.thoughtseize.silo.factory
import com.miloszjakubanis.thoughtseize.silo.{Silo, SimpleSilo}
import com.miloszjakubanis.thoughtseize.factory.{IDFactory, SimpleIDFactory}
import com.miloszjakubanis.thoughtseize.ID
import scala.collection.mutable

object SimpleSiloFactory:
  def apply(silo: SimpleSilo): SimpleSilo = ???

class SimpleSiloFactory extends SiloFactory:

  private[this] val idFactory: IDFactory = SimpleIDFactory()

  val map = mutable.HashMap[ID, String]()

  def silo(): Silo[_, _] = 
    val id = idFactory.nextID()
    SimpleSilo(id, id.toString)