package com.miloszjakubanis.thoughtseize.storage.cache

import com.miloszjakubanis.thoughtseize.storage.Storage

trait Cache[T, T2, T3 <: Long | String] extends Storage[T, T2, T3]:
  val cacheSizeLimit: Long