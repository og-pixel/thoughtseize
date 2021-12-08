package com.miloszjakubanis.thoughtseize.storage

import java.nio.file.{Path, Paths}
import com.miloszjakubanis.thoughtseize.storage.LocationPlace._

class Location(
    private[this] val location: Path,
    private[this] val locationName: String
) {

  private[this] val root: Path = location.resolve(locationName)

  def apply(): Path = root

  def get: Path = root

  override def toString(): String = root.toString
}
object Location {
  def apply(locationName: String, place: LocationPlace = HOME): Location = {
    place match {
      case HOME =>
        new Location(
          Paths.get(System.getProperty("user.home")),
          locationName
        )
      case ROOT => new Location(Paths.get("/"), locationName)
      case TMP  => new Location(Paths.get("/tmp"), locationName)
    }
  }
}
