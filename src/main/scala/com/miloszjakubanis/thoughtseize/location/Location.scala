package com.miloszjakubanis.thoughtseize.location

import com.miloszjakubanis.thoughtseize.silo.{Silo, SimpleSilo}

import java.nio.file.Files
import java.io.File
import java.nio.file.{Path, Paths}

object Location:

  given Conversion[String, Path] with
    def apply(s: String): Path = Paths.get(s).nn

  val userHome = System.getProperty("user.home").nn

  def apply(name: String): Location[_] = getLocationStrategy(name)

  def getLocationStrategy(name: String): Location[_] =
    val a = name.toLowerCase.nn.trim.nn
      a match
       case "docker" => DockerLocationStrategy()
       case "simple" => SimpleLocationStrategy()
       case _ => SimpleLocationStrategy()

// TODO trait Location[T <: Silo[_, _]](private[this] val local: String):
trait Location[T <: SimpleSilo](private[this] val local: String):

  lazy val location: String = s"${Location.userHome}/$local"
  //TODO might not need it
  lazy val asPath = Paths.get(location).nn
  lazy val silo: T 

  //TODO create directory creation system
  def locationExists: Boolean = File(location).isDirectory 

  def createDir(location: Path): Boolean =
    if dirExists(location) then 
      Files.createDirectory(location)
      true
    else false

  private[this] def dirExists(path: Path): Boolean = ???