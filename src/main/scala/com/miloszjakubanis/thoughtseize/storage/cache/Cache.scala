package com.miloszjakubanis.thoughtseize.silo.cache

import com.miloszjakubanis.thoughtseize.silo.Sto

trait Cache[K, V] extends Storage[K, V]:

  val cacheLimit: Long

  def getSiloContent(key: K): V
  val z = 1