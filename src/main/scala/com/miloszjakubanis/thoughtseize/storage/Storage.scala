package com.miloszjakubanis.thoughtseize.storage

trait Storage[K, V]:
  def getSiloContent(key: K): V