package com.miloszjakubanis.thoughtseize

import java.io.File

class SimpleSilo extends Silo[File]:
  var lock: String = ""
  var isLocked: Boolean = false
  def getSiloContent: File = ???
