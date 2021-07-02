package com.miloszjakubanis.thoughtseize.storage

abstract class AbstractFileStorage[T2, T3 <: Long | String] extends FileStorage[T2, T3]:

  

  if !storageLocationExists then createStorageLocation()