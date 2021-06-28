package com.miloszjakubanis.thoughtseize.jobs.factory

import com.miloszjakubanis.thoughtseize.storage.Storage
import com.miloszjakubanis.thoughtseize.jobs.Job

trait JobFactory(val storage: Storage[_, _]):
  def job(): Job[_, _]