package com.miloszjakubanis.thoughtseize.jobs

import com.miloszjakubanis.thoughtseize.storage.{Storage, SimpleStorage}
import com.miloszjakubanis.thoughtseize.location.Location

class SendToFileJob(val content: Array[Byte], val simpleStorage: Storage[Array[Byte], Long], val key: Long) extends Job[Array[Byte], Unit]:

  def executeJob: Unit = 
    function(content)

  val function: Array[Byte] => Unit = (e => 
    simpleStorage.append(content, key)
  )
    
  val repeat: Boolean = false

  val results: Seq[Unit] = Seq()