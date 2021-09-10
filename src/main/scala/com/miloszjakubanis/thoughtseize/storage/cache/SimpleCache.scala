package com.miloszjakubanis.thoughtseize.storage.cache

import com.miloszjakubanis.thoughtseize.storage.cache.Cache
import scala.collection.mutable.ArrayBuffer
import scala.collection.mutable.Seq

class SimpleCache[A] extends Cache[Seq[A]]:

  val cacheSizeLimit: Long = 1 << 10

  //TODO this variable name is misleading
  private[this] val storage: Seq[A] = Seq()
  
  def write(content: Seq[A], index: Long): Option[Seq[A]] = 
    //TODO check if successful
    storage :++ content
    Option(storage)
  
  def append(content: Seq[A], index: Long): Option[Seq[A]] = 
    //TODO check if successful
    storage :++ content
    Option(storage)
  
  def read(index: Long): Option[Seq[A]] = ???

  def cache: Seq[A] = storage