package com.miloszjakubanis.thoughtseize.storage

import play.api.libs.json.{Reads, Writes}

import scala.util.Try

object Database {
  implicit def stringToArr(s: String): Array[Byte] = s.getBytes
}

trait Database {

  def writeBytes(namespace: String, id: String, content: Array[Byte], overrideFile: Boolean): Try[Unit]
  def readBytes(namespace: String, id: String): Try[Array[Byte]]

  def writeJson[A](namespace: String, id: String, content: A, overrideFile: Boolean)(implicit writes: Writes[A]): Try[Unit]
  def readJson[A](namespace: String, id: String)(implicit reads: Reads[A]): Option[A]
}



