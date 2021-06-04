package com.miloszjakubanis.thoughtseize.silo.factory

import com.miloszjakubanis.thoughtseize.silo.Silo

trait SiloFactory {
  def silo(): Silo[_, _]
}