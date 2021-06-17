package com.miloszjakubanis.thoughtseize.storage

abstract class AbstractFileStorage[T, T2, T3 <: Long | String] extends FileStorage[T, T2, T3]:

  if !storageLocationExists then createStorageLocation()
