package com.miloszjakubanis.thoughtseize.location

import com.miloszjakubanis.thoughtseize.storage.SimpleStorage
import com.miloszjakubanis.thoughtseize.storage.factory.{SiloFactory, SimpleSiloFactory}

class DockerLocationStrategy(folderName: String = "filesystem") extends Location[SimpleStorage](folderName):

  val factory: SimpleSiloFactory = new SimpleSiloFactory() //TODO work on new/apply

  override lazy val location: String = s"/$folderName"
  override lazy val silo: SimpleStorage = factory.silo()