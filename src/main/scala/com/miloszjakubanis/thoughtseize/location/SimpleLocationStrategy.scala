package com.miloszjakubanis.thoughtseize.location

import com.miloszjakubanis.thoughtseize.storage.Storage

class SimpleLocationStrategy(folderName: String = ".filesystem") extends Location[Storage[_, _]](folderName):
  lazy val silo: Storage[_, _] = ???