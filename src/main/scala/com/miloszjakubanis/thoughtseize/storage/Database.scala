package com.miloszjakubanis.thoughtseize.storage

import java.io.Serializable
import scala.util.Try

object Database {

  def apply(): Database = ???
}


trait Database {
  val location: Location

  def writeBytes(namespace: String, id: String, content: Array[Byte]): Try[Unit]
  def writeObject[A <: Serializable](namespace: String, id: String, content: A): Try[Unit]

  def readBytes(namespace: String, id: String): Try[Array[Byte]]
  def readObject[A <: Serializable](namespace: String, id: String): Try[A]
}
