package com.miloszjakubanis.thoughtseize.factory

import com.miloszjakubanis.thoughtseize.ID

class SimpleIDFactory extends IDFactory:
  var id: ID = 0
  def nextID(): ID = 
    id += 1
    id