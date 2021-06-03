package com.miloszjakubanis.thoughtseize

import java.nio.file.Paths
import java.nio.file.Path
import java.io.File

object LocationStrategy:
  private[this] val userHome = System.getProperty("user.home").nn

trait LocationStrategy(private[this] val local: String):
  lazy val location: String = s"${LocationStrategy.userHome}/$local"
  lazy val asPath = Paths.get(location).nn

  def dirExists: Boolean = {
    if File(location).isDirectory then true
    else false
  }

  def createDir(location: String): Boolean = {
    false
  }