package com.miloszjakubanis.thoughtseize.user

import com.miloszjakubanis.thoughtseize.id.ID

trait User:
  val userId: ID
  val userName: String