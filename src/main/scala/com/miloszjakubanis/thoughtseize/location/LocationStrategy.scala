package com.miloszjakubanis.thoughtseize.location

import com.miloszjakubanis.thoughtseize.silo.Silo

import java.io.File
import java.nio.file.{Path, Paths}

object LocationStrategy:

  private[this] val userHome = System.getProperty("user.home").nn

  def getLocationStrategy(name: String): LocationStrategy[_] =
    val a = name.toLowerCase.nn.trim.nn
     a match
      case "docker" => DockerLocationStrategy()
      case "simple" => SimpleLocationStrategy()
      case _ => SimpleLocationStrategy()



trait LocationStrategy[T <: Silo[_, _]](private[this] val local: String):

  lazy val location: String = s"${LocationStrategy.userHome}/$local"
  lazy val asPath = Paths.get(location).nn
  lazy val silo: T 

  def dirExists: Boolean =
    if File(location).isDirectory then true
    else false

  def createDir(location: String): Boolean =
    false
