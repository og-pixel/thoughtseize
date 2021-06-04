package com.miloszjakubanis.thoughtseize.silo.factory

import com.miloszjakubanis.thoughtseize.silo.Silo

trait SiloFactory[T <: Silo[_, _]] {
  def silo(): T 
}