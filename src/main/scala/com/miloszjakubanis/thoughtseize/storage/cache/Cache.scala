package com.miloszjakubanis.thoughtseize.storage.cache

import com.miloszjakubanis.thoughtseize.storage.Storage

trait Cache[T2] extends Storage[T2, Long]:
  val cacheSizeLimit: Long