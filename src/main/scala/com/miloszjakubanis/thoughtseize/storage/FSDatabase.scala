package com.miloszjakubanis.thoughtseize.storage

import scala.util.Try
import java.io.Serializable
import com.miloszjakubanis.thoughtseize.storage.Location
import java.nio.file.Files
import java.nio.file.{Path, Paths}
import scala.util.Success
import scala.util.Failure
import scala.util.control.NonFatal
import java.io.File




class FSDatabase(val location: Location) extends Database:

  Files.createDirectories(location())

  override def readBytes(namespace: String, id: String): Try[Array[Byte]] = ???

  override def readObject[A <: Serializable](namespace: String, id: String): Try[A] = ???

  override def writeBytes(namespace: String, id: String, content: Array[Byte]): Try[Unit] = {
    val file: Path = location().resolve(namespace).nn.resolve(id).nn

    Files.createDirectories(file.getParent.nn)
    if !Files.exists(file) then Files.createFile(file)
    try {
      Files.write(file, content)
      Success(())
    } catch {
      case NonFatal(e) => Failure(e)
    }

  }

  override def writeObject[A <: Serializable](namespace: String, id: String, content: A): Try[Unit] = ???