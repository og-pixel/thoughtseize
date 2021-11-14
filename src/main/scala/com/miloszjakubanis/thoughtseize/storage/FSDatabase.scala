package com.miloszjakubanis.thoughtseize.storage

import java.io._
import java.nio.file.{Files, Path}
import scala.util.{Failure, Success, Try}
import scala.util.control.NonFatal

class FSDatabase(val location: Location) extends Database {


  Files.createDirectories(location())

  override def readBytes(namespace: String, id: String): Try[Array[Byte]] = {
    val file: Path = location().resolve(namespace).resolve(id)
    try {
      val a = new FileInputStream(file.toString)
      Success(a.readAllBytes)
    } catch {
      case NonFatal(e) => Failure(e)
    }
  }

  override def readObject[A <: Serializable](
                                              namespace: String,
                                              id: String
                                            ): Try[A] = {

  val file: Path = location().resolve(namespace).resolve(id)
  try {
    val ois = new ObjectInputStream(new FileInputStream(file.toString))
    val result = ois.readObject.asInstanceOf[A]
    ois.close
    Success(result)
  } catch {
    case NonFatal(e) => Failure(e)
  }
}

  override def writeBytes(
                           namespace: String,
                           id: String,
                           content: Array[Byte]
                         ): Try[Unit] = {
    val file: Path = location().resolve(namespace).resolve(id)
    try {
      if(fileExists(file)) throw new IOException("File Already Exists")
      Files.createDirectories(file.getParent)
      if (!Files.exists(file)) Files.createFile(file)
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
    val file: Path = location().resolve(namespace).resolve(id)
    try {
      if(fileExists(file)) throw new IOException("File Already Exists")
      Files.createDirectories(file.getParent)
      if (!Files.exists(file)) Files.createFile(file)
      val oos = new ObjectOutputStream(new FileOutputStream(file.toString))
      oos.writeObject(content)
      oos.close()
      Success(())
    } catch {
      case NonFatal(e) => Failure(e)
    }

  }

  private[this] def fileExists(filePath: Path): Boolean = Files.exists(filePath)
}