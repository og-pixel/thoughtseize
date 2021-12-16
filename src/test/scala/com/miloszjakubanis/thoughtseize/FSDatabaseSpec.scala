package com.miloszjakubanis.thoughtseize

import com.miloszjakubanis.thoughtseize.storage.{FSDatabase, Location, LocationPlace}
import com.typesafe.scalalogging.StrictLogging
import io.circe.generic.auto._
import utest.{TestSuite, Tests, test}

import scala.language.implicitConversions

object FSDatabaseSpec extends TestSuite with StrictLogging {
  override def tests: Tests = Tests {

    val namespace = "default"
    val fs = new FSDatabase(Location("tmp-test", LocationPlace.TMP))

    val person = Person("Milosz", 25)

    test("Read JSon") - {
      fs.writeJson(namespace, "1", person)

      val z = fs.readJson[Person](namespace, "1").get

      assert(z == person)
    }
  }
}
