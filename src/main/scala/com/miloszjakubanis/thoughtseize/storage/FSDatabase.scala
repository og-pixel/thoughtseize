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
import java.io.IOException
import java.io.ObjectOutputStream
import java.io.FileOutputStream
import java.io.ObjectInputStream
import java.io.FileInputStream

class FSDatabase(val location: Location) extends Database:

  Files.createDirectories(location())

  override def readBytes(namespace: String, id: String): Try[Array[Byte]] = 
    val file: Path = location().resolve(namespace).nn.resolve(id).nn
    try{
      val a = FileInputStream(file.toString)
      Success(a.readAllBytes.nn)
    }catch {
      case NonFatal(e) => Failure(e)
    }

  override def readObject[A <: Serializable](
      namespace: String,
      id: String
  ): Try[A] =
    val file: Path = location().resolve(namespace).nn.resolve(id).nn
    try {
      val ois = new ObjectInputStream(new FileInputStream(file.toString))
      val result = ois.readObject.asInstanceOf[A]
      ois.close
      Success(result)
    } catch {
      case NonFatal(e) => Failure(e)
    }

  override def writeBytes(
      namespace: String,
      id: String,
      content: Array[Byte]
  ): Try[Unit] = {
    val file: Path = location().resolve(namespace).nn.resolve(id).nn
    try {
      if fileExists(file) then throw new IOException("File Already Exists")
      Files.createDirectories(file.getParent.nn)
      if !Files.exists(file) then Files.createFile(file)
      Files.write(file, content)
      Success(())
    } catch {
      case NonFatal(e) => Failure(e)
    }

  }

  override def writeObject[A <: Serializable](
      namespace: String,
      id: String,
      content: A
  ): Try[Unit] = {
    val file: Path = location().resolve(namespace).nn.resolve(id).nn
    try {
      if fileExists(file) then throw new IOException("File Already Exists")
      Files.createDirectories(file.getParent.nn)
      if !Files.exists(file) then Files.createFile(file)
      val oos = new ObjectOutputStream(new FileOutputStream(file.toString))
      oos.writeObject(content)
      oos.close
      Success(())
    } catch {
      case NonFatal(e) => Failure(e)
    }

  }

  private[this] def fileExists(filePath: Path): Boolean = Files.exists(filePath)
