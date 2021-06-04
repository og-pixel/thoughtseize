package com.miloszjakubanis.thoughtseize.location

import com.miloszjakubanis.thoughtseize.silo.SimpleSilo
import com.miloszjakubanis.thoughtseize.silo.factory.{SiloFactory, SimpleSiloFactory}

class DockerLocationStrategy(folderName: String = "filesystem") extends LocationStrategy[SimpleSilo](folderName):

  val factory: SimpleSiloFactory = new SimpleSiloFactory() //TODO work on new/apply

  override lazy val location: String = s"/$folderName"
  override lazy val silo: SimpleSilo = factory.silo()