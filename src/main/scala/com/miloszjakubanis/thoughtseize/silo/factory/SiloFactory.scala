package com.miloszjakubanis.thoughtseize.silo.factory

import com.miloszjakubanis.thoughtseize.silo.Silo
import java.nio.file.Path

trait SiloFactory[T <: Silo[_, _]] {
  def silo(location: Path): T 
}