package com.miloszjakubanis.thoughtseize.location

import com.miloszjakubanis.thoughtseize.silo.SimpleSilo
import com.miloszjakubanis.thoughtseize.silo.factory.{SiloFactory, SimpleSiloFactory}

class DockerLocationStrategy(folderName: String = "filesystem") extends LocationStrategy[SimpleSilo](folderName):

  // val factory: SiloFactory = SimpleSiloFactory()

  override lazy val location: String = s"/$folderName"
  override lazy val silo: SimpleSilo = SimpleSilo(1, "das")//factory.silo()