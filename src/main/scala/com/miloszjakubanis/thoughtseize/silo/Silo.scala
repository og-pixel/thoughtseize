package com.miloszjakubanis.thoughtseize.silo

trait Silo[K, T]:
  def getSiloContent(key: K): T