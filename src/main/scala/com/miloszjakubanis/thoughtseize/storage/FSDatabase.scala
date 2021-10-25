package com.miloszjakubanis.thoughtseize.storage

import scala.util.Try
import java.io.Serializable
import com.miloszjakubanis.thoughtseize.storage.Location
import java.nio.file.Files
import java.nio.file.Path
import scala.util.Success
import scala.util.Failure
import scala.util.control.NonFatal

class FSDatabase(val location: Location) extends Database:

  Files.createDirectories(location.root)

  def readBytes(namespace: Path, id: String): Try[Array[Byte]] = ???

  def readObject[A <: Serializable](namespace: Path, id: String): Try[A] = ???

  def writeBytes(namespace: Path, id: String, content: Array[Byte]): Try[Unit] = {
    val file: Path = location().resolve(namespace).nn.resolve(id).nn

    if !Files.exists(file) then Files.createFile(file)
    try {
      Files.write(file, Array[Byte](1))
      Success(())
    } catch {
      case NonFatal(e) => Failure(e)
    }

  }

  def writeObject[A <: Serializable](namespace: Path, id: String, content: A): Try[Unit] = ???