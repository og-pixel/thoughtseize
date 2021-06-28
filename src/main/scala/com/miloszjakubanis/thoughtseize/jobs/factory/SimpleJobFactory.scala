package com.miloszjakubanis.thoughtseize.jobs.factory

import com.miloszjakubanis.thoughtseize.storage.Storage
import com.miloszjakubanis.thoughtseize.jobs.Job

class SimpleJobFactory(storage: Storage[_, _]) extends JobFactory(storage):

  override def job(): Job[_, _] = ???