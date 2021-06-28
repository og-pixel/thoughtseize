package com.miloszjakubanis.thoughtseize.jobs

import com.miloszjakubanis.thoughtseize.storage.Storage

trait StorageJob[In, Out](val storage: Storage[_, _]) extends Job[In, Out]