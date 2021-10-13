package com.miloszjakubanis.thoughtseize.user

import scala.collection.mutable.ArrayBuffer
import com.miloszjakubanis.thoughtseize.ID
// @SerialVersionUID(10000L)
trait User extends Serializable:
  val userId: ID
  val userName: String