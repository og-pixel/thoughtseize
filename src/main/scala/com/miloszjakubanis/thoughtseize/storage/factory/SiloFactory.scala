package com.miloszjakubanis.thoughtseize.storage.factory

import com.miloszjakubanis.thoughtseize.storage.Storage

trait SiloFactory[T <: Storage[_, _]] {
  def silo(): T 
}