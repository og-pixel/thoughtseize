package com.miloszjakubanis.thoughtseize.user.factory

import com.miloszjakubanis.thoughtseize.id.factory.IDFactory
import com.miloszjakubanis.thoughtseize.id.factory.SimpleIDFactory
import com.miloszjakubanis.thoughtseize.user.User

trait UserFactory:
  val idFactory: IDFactory = SimpleIDFactory()
  def nextUser(userName: String): User