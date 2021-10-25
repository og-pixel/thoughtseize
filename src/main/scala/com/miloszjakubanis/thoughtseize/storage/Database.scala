package com.miloszjakubanis.thoughtseize.storage

import scala.util.Try
import java.io.Serializable
import java.nio.file.Path

trait Database:

  def writeBytes(namespace: Path, id: String, content: Array[Byte]): Try[Unit]
  def writeObject[A <: Serializable](namespace: Path, id: String, content: A): Try[Unit]

  def readBytes(namespace: Path, id: String): Try[Array[Byte]]
  def readObject[A <: Serializable](namespace: Path, id: String): Try[A]
