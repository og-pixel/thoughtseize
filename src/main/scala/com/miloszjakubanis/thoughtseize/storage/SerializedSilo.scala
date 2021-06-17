package com.miloszjakubanis.thoughtseize.storage

import scala.collection.mutable
import java.io.{ObjectOutputStream, FileOutputStream}
import java.io.File

// class SerializedSilo[T <: File with Serializable] extends Storage[String, T]:

//   private[this] val children: mutable.HashMap[String, T] = mutable.HashMap()
//   def getSiloContent(key: String): T = children(key)