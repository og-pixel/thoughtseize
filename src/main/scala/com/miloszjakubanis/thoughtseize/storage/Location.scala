package com.miloszjakubanis.thoughtseize.storage

import java.nio.file.{Path, Paths}

object Location:

  def apply(locationName: String): Location =
    new Location(Paths.get(System.getProperty("user.home").nn).nn, locationName)

class Location(
    private[this] val location: Path,
    private[this] val locationName: String
):

  private[this] val root: Path = location.resolve(locationName).nn

  def apply(): Path = root

  override def toString(): String = root.toString