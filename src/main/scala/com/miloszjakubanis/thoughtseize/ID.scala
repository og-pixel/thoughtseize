package com.miloszjakubanis.thoughtseize

opaque type ID = Int

object ID:
  def apply(num: Int): ID = num
