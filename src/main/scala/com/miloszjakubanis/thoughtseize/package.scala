package com.miloszjakubanis.thoughtseize

import java.nio.file.{Path, Paths}

given Conversion[String, Path] with
  def apply(s: String): Path = Paths.get(s).nn

given Conversion[String, Array[Byte]] with
  def apply(s: String): Array[Byte] = s.getBytes.nn

