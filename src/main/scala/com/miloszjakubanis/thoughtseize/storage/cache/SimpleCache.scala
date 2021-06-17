package com.miloszjakubanis.thoughtseize.silo.cache

import com.miloszjakubanis.thoughtseize.storage.cache.Cache
import scala.collection.mutable.ArrayBuffer

class SimpleCache extends Cache[ArrayBuffer[Byte], Array[Byte], Long]:

  val cacheSizeLimit: Long = 1 << 10

  val storage: ArrayBuffer[Byte] = ArrayBuffer()
  
  def write(content: Array[Byte], index: Long): Option[Array[Byte]] = 
    //TODO check if successful
    storage ++= content
    Option(storage.toArray)