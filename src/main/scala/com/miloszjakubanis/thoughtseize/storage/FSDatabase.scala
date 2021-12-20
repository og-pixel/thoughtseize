package com.miloszjakubanis.thoughtseize.storage

import java.io._
import java.nio.file.{Files, Path}
import scala.util.{Failure, Success, Try}
import scala.util.control.NonFatal
import io.circe._
import io.circe.generic.auto._
import io.circe.parser._
import io.circe.syntax._

import scala.language.implicitConversions
import scala.reflect.ClassTag
import scala.reflect.runtime.universe._

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

  override def readJson[A: Decoder](namespace: String, id: String): Try[A] = {
    val file: Path = location().resolve(namespace).resolve(id + ".json")
    try {
      val a = new FileInputStream(file.toString)

      val res: A = parser
        .decode[A](new String(a.readAllBytes()))
        .fold(_ => throw new Exception("todo, json parse erorr"), v => v)

      Success(res)
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
      if (fileExists(file)) throw new IOException("File Already Exists")
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
      if (fileExists(file)) throw new IOException("File Already Exists")
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

  override def writeJson[A: Encoder](
      namespace: String,
      id: String,
      content: A
  ): Try[Unit] = {
    val file: Path = location().resolve(namespace).resolve(id + ".json")
    try {
      if (fileExists(file)) throw new IOException("File Already Exists")
      Files.createDirectories(file.getParent)
      if (!Files.exists(file)) Files.createFile(file)
//      val oos = new ObjectOutputStream(new FileOutputStream(file.toString))
//      println(s"wrote: ${content.asJson.noSpaces}")
//      oos.writeObject(content.asJson.noSpaces)
//      oos.close()

      Files.write(file, content.asJson.noSpaces.getBytes)
      Success(())
    } catch {
      case NonFatal(e) => Failure(e)
    }
  }

  private[this] def fileExists(filePath: Path): Boolean = Files.exists(filePath)
}
