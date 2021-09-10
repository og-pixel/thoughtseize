package com.miloszjakubanis.thoughtseize

import java.nio.file.Paths
import com.typesafe.config.ConfigFactory
import com.miloszjakubanis.thoughtseize.location.Location
import com.miloszjakubanis.thoughtseize.config.DefaultConfig
import com.miloszjakubanis.thoughtseize.location.*
import com.miloszjakubanis.thoughtseize.jobs.{SimpleJob, PrintingJob}
import com.miloszjakubanis.thoughtseize.jobs.SendToFileJob
import com.miloszjakubanis.thoughtseize.user.User
import com.miloszjakubanis.thoughtseize.user.factory.SimpleUserFactory
import com.miloszjakubanis.thoughtseize.jobs.executor.SimpleJobExecutor
import com.miloszjakubanis.thoughtseize.jobs.executor.MainJobExecutor
import com.miloszjakubanis.thoughtseize.user.SimpleUser
import scala.sys.ShutdownHookThread
import scala.concurrent.Future
import java.net.URL

//import com.miloszjakubanis.`aether-vial`.AbstractJob

given Conversion[String, Array[Byte]] with
  def apply(s: String): Array[Byte] = s.getBytes.nn

@main def hello =
  val location = Location(
    DefaultConfig("config.location"),
    DefaultConfig("config.workers").toInt
  ).asInstanceOf[SimpleLocationStrategy]

  implicit val ec: scala.concurrent.ExecutionContext = scala.concurrent.ExecutionContext.global
  // val main = MainJobExecutor(
  //   new SimpleUserFactory()
  // )

  // main.createUser("Milosz")
  // Thread.sleep(1000)
  // val user = main.findUser("Milosz").get
  // main.submitJob(user, PrintingJob(s"Hello world from ${user.userName}"))


  val list = List(1, 2, 3)
  val listA = List('a', 'b', 'c')
  

  val checker: List[String] = listA.flatMap(c => list.map(e => s"$c$e\n"))

  val result = for {
    ap <- list
    if ap != 1 
    az <- listA
  } yield s"$ap|$az\n"

  println(result.mkString)
  val aaaa = new URL(
  
  // val aaa = new com.miloszjakubanis.`aether-vial`.AbstractJob[String, Unit]("hello world")(Future{println(_)})
 // val aaa = AbstractJob[String, Int](e => Future{Integer.parseInt(e)})

  // main.shutdown()
