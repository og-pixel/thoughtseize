package com.miloszjakubanis.thoughtseize.location

import com.miloszjakubanis.thoughtseize.silo.Silo

class SimpleLocationStrategy(folderName: String = ".filesystem") extends Location[Silo[_, _]](folderName):
  lazy val silo: Silo[_, _] = ???