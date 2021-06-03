package com.miloszjakubanis.thoughtseize

class DockerLocationStrategy(folderName: String = "filesystem") extends LocationStrategy(folderName):
  override lazy val location: String = s"/$folderName"
