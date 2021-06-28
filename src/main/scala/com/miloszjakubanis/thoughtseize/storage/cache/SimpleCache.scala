package com.miloszjakubanis.thoughtseize.storage.cache

import com.miloszjakubanis.thoughtseize.storage.cache.Cache
import scala.collection.mutable.ArrayBuffer

class SimpleCache extends Cache[Array[Byte], Long]:

  val cacheSizeLimit: Long = 1 << 10

  private[this] val storage: ArrayBuffer[Byte] = ArrayBuffer()
  
  def write(content: Array[Byte], index: Long): Option[Array[Byte]] = 
    //TODO check if successful
    storage ++= content
    Option(storage.toArray)
  
  def append(content: Array[Byte], index: Long): Option[Array[Byte]] = 
    //TODO check if successful
    storage ++= content
    Option(storage.toArray)