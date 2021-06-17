package com.miloszjakubanis.thoughtseize.storage.factory

import com.miloszjakubanis.thoughtseize.storage.Storage

trait StorageFactory[T <: Storage[_, _, _]]:
  def silo(): T 