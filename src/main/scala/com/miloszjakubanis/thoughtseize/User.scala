package com.miloszjakubanis.thoughtseize

import com.miloszjakubanis.thoughtseize.User.Password
import play.api.libs.functional.syntax._
import play.api.libs.json._

object User extends Stringable[User] {

  type Password = String

  implicit val writes: Writes[User] =
    (userDAO: User) =>
      Json.obj(
      "username" -> userDAO.login,
      "password" -> userDAO.password
  )

  implicit val reads: Reads[User] = (
    (JsPath \ "username").read[String] and
      (JsPath \ "password").read[String]
    )(User.apply _)
}

case class User(login: String, password: Password)
