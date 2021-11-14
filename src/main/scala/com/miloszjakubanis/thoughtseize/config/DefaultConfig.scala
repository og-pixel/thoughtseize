package com.miloszjakubanis.thoughtseize.config

import com.typesafe.config.ConfigFactory
import scala.collection.immutable

//TODO most likely to be deleted
object DefaultConfig {
  //TODO first value is default
  private[this] val CONFIG_DEFAULTS = immutable.HashMap[String, Array[String]](
    "config.location" -> Array("simple", "docker"),
    "config.user" -> Array("default"),
    "config.workers" -> Array("5"),
  )

  private[this] val conf = ConfigFactory.load()

  //TODO made to throw errors on not getting defaults
  //TODO breaks if config doesn't exists
  def getOrDefault(key: String): String = {
    conf.getString(key) match {
      case s: String =>
        if(CONFIG_DEFAULTS(key).contains(s)) s
        else CONFIG_DEFAULTS(key)(0)
      case _ => CONFIG_DEFAULTS(key)(0)
    }
  }

  def apply(key: String): String = getOrDefault(key)
}
