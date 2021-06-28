package com.miloszjakubanis.thoughtseize.user.factory

import com.miloszjakubanis.thoughtseize.user.{User, SimpleUser}

class SimpleUserFactory extends UserFactory:

  def nextUser(userName: String): User = SimpleUser(idFactory.nextID, userName)