package com.miloszjakubanis.thoughtseize.storage

import com.miloszjakubanis.thoughtseize.location.Location
import com.miloszjakubanis.thoughtseize.storage.cache.Cache
import com.miloszjakubanis.thoughtseize.silo.cache.SimpleCache

trait FileStorage[T, T2, T3 <: Long | String] extends Storage[T, T2, T3]:
  val location: Location[_]
  val cache: Cache[_, _, _] = SimpleCache()