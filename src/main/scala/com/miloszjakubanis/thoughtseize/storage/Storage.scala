package com.miloszjakubanis.thoughtseize.storage

import java.nio.file.Path
import java.nio.file.Files

trait Storage[T, T2, T3 <: Long | String]:

  val storage: T
  def apply: T = storage
  def write(content: T2, index: T3): Option[T2]