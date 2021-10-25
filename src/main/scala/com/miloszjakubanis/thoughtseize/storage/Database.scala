package com.miloszjakubanis.thoughtseize.storage

import scala.util.Try
import java.io.Serializable
import java.nio.file.{Path, Paths}


given Conversion[String, Path] with
  def apply(s: String): Path = Paths.get(s).nn

trait Database:
  def writeBytes(namespace: String, id: String, content: Array[Byte]): Try[Unit]
  def writeObject[A <: Serializable](namespace: String, id: String, content: A): Try[Unit]

  def readBytes(namespace: String, id: String): Try[Array[Byte]]
  def readObject[A <: Serializable](namespace: String, id: String): Try[A]
