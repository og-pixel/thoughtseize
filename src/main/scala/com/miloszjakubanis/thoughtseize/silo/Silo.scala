package com.miloszjakubanis.thoughtseize.silo

import java.nio.file.Path

trait Silo[K, T]:

  val location: Path

  def apply(key: K): T =  getSiloContent(key)

  def getSiloContent(key: K): T

  def put(key: K, value: T): Option[T]

  def remove(key: K): Option[T]