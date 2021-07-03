package com.miloszjakubanis.thoughtseize.jobs.executor

import com.miloszjakubanis.thoughtseize.user.factory.UserFactory
import com.miloszjakubanis.thoughtseize.user.User
import com.miloszjakubanis.thoughtseize.jobs.SimpleJob
import com.miloszjakubanis.thoughtseize.jobs.Job
import scala.collection.mutable.ArrayBuffer
import com.miloszjakubanis.thoughtseize.storage.cache.{Cache, SimpleCache}

class MainJobExecutor(
  val userFactory: UserFactory,
) extends JobExecutor(1):

  //TODO too generic
  val userList: Cache[User] = SimpleCache[User]()

  def createUser(userName: String): Unit =
    //TODO delete thread.sleep
    val fun: UserFactory => User = f => {
      Thread.sleep(100)
      f.nextUser(userName)
    }
    addJob(SimpleJob[UserFactory, User](userFactory, 1, fun, userList))
  

  def findUser(name: String): Option[User] =
    for(user <- userList)
      if user.userName == name then return Option(user)
    Option.empty


  def submitJob(user: User, job: Job[_, _]): Unit = 
    user.jobExecutor.addJob(job)
   
  override def shutdown(): Unit = 
    userList.foreach(e => e.jobExecutor.shutdown())
    super.shutdown()

  override def shutdownNow(): Unit =
    userList.foreach(e => e.jobExecutor.shutdownNow())
    super.shutdownNow()