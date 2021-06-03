package com.miloszjakubanis.thoughtseize

trait Silo[T]:
  def getSiloContent: T
