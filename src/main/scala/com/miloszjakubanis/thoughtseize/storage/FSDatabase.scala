package com.miloszjakubanis.thoughtseize.storage

import play.api.libs.json.{Json, Reads, Writes}

import java.io._
import java.nio.file.{Files, Path}
import scala.util.control.NonFatal
import scala.util.{Failure, Success, Try}

class FSDatabase(val rootPath: Path) extends Database {

  private[this] def fileExists(filePath: Path): Boolean = Files.exists(filePath)

  Files.createDirectories(rootPath)

  override def readBytes(namespace: String, id: String): Try[Array[Byte]] = {
    val file: Path = rootPath.resolve(namespace).resolve(id)
    try {
      val data = new FileInputStream(file.toString)
      Success(data.readAllBytes)
    } catch {
      case NonFatal(e) => Failure(e)
    }
  }

  override def writeBytes(
                           namespace: String,
                           id: String,
                           content: Array[Byte],
                           overrideFile: Boolean = false
                         ): Try[Unit] = {
    val file: Path = rootPath.resolve(namespace).resolve(id)
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

  override def writeJson[A](namespace: String, id: String, content: A, overrideFile: Boolean = false)(implicit writes: Writes[A]): Try[Unit] = {
    writeBytes(
      namespace,
      id,
      Json.toJson(content)
        .toString()
        .getBytes
    )
  }

  override def readJson[A](namespace: String, id: String)(implicit reads: Reads[A]): Option[A] = {
    readBytes(namespace, id).fold(_ => Option.empty, v => {
      Json.fromJson(
        Json.parse(new String(v))
      ).fold(_ => Option.empty, v2 => Option(v2))
    })
  }
}
