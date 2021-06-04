package com.miloszjakubanis.thoughtseize.id.factory

import com.miloszjakubanis.thoughtseize.id.ID

class SimpleIDFactory extends IDFactory:
  var id: ID = 0
  def nextID(): ID = 
    id += 1
    id