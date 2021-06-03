package com.miloszjakubanis.thoughtseize

import java.nio.file.Paths

@main def hello =
  val simple: LocationStrategy = SimpleLocationStrategy()
  val docker: LocationStrategy = DockerLocationStrategy()
  println(docker.location)
  println(docker.dirExists)