package com.miloszjakubanis.thoughtseize.storage

import java.nio.file.Path

trait Location(val root: Path):
  def apply(): Path = root