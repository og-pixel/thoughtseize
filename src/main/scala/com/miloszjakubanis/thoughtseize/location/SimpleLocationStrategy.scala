package com.miloszjakubanis.thoughtseize.location

import com.miloszjakubanis.thoughtseize.silo.{SimpleSilo, Silo}
import com.miloszjakubanis.thoughtseize.silo.factory.SimpleSiloFactory
import java.nio.file.Paths

class SimpleLocationStrategy(folderName: String = ".filesystem") extends Location[SimpleSilo](folderName):

  val factory: SimpleSiloFactory = new SimpleSiloFactory() //TODO work on new/apply

  lazy val silo: SimpleSilo = factory.silo(asPath)