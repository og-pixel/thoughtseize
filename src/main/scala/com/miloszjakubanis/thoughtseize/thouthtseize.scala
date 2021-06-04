package com.miloszjakubanis.thoughtseize

import com.typesafe.config.ConfigFactory
import com.miloszjakubanis.thoughtseize.ConfigLoader
import com.miloszjakubanis.thoughtseize.location.LocationStrategy
import scala.collection.immutable

type ID = Long

object ConfigValues:

  //TODO first value is default
  private[this] val CONFIG_DEFAULTS = immutable.HashMap[String, Array[String]](
    "config.location" -> Array("simple", "docker"),
    "config.user" -> Array("default"),
  )

  private[this] val conf = ConfigFactory.load().nn

  //TODO made to throw erros on not getting defaults
  //TODO breaks if config doesn't exists
  def getOrDefault(key: String): String = 
    conf.getString(key) match 
      case s: String => 
        if CONFIG_DEFAULTS(key).contains(s) then s
        else CONFIG_DEFAULTS(key).nn(0).nn
      case _ => CONFIG_DEFAULTS(key).nn(0).nn

  def apply(key: String): String = getOrDefault(key)