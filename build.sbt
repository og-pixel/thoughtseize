import sbt.Credentials
import sbt.Keys.{credentials, publishTo}

lazy val SCALA_2 = "2.13.7"

lazy val thoughtseize: Project = project
  .enablePlugins(PackPlugin, BuildInfoPlugin)
  .in(file("."))
  .settings(
    name := "Thoughtseize",
    organizationName := "Milosz Jakubanis",
    version := "0.0.2-SNAPSHOT",
    scalaVersion := SCALA_2,
    organization := "com.miloszjakubanis",
    libraryDependencies ++= Seq(
      //Logback
      //Logback
      "ch.qos.logback" % "logback-classic" % "1.2.6",
      "com.typesafe.scala-logging" %% "scala-logging" % "3.9.4",

      //Config
      "com.typesafe" % "config" % "1.4.1",
      "com.lihaoyi" %% "utest" % "0.7.10" % Test,
      //Circe for JSon Parsing
      "io.circe" %% "circe-core" % "0.14.1",
      "io.circe" %% "circe-generic" % "0.14.1",
      "io.circe" %% "circe-parser" % "0.14.1",
      //New Json Parsing, from Play Framework
      "com.typesafe.play" %% "play-json" % "2.9.2"
    ),
    testFrameworks += new TestFramework("utest.runner.Framework"),
    scalacOptions ++= Seq(
      "-feature",
      "-deprecation",
      "-unchecked",
      "-language:implicitConversions"
    ),
    buildInfoKeys := Seq[BuildInfoKey](name, version, scalaVersion, sbtVersion),
    resolvers := Seq(
      "releases" at s"https://artifact.miloszjakubanis.com/repository/earth/",
      "snapshots" at s"https://artifact.miloszjakubanis.com/repository/moon/"
    ),
    //Credentials
    versionScheme := Some("early-semver"),
    publishMavenStyle := true,
    credentials += Credentials(
      new File(Path.userHome.absolutePath + "/.nexus/credentials")
    ),
    publishTo := Some("Sonatype Nexus Repository Manager" at {
      if (isSnapshot.value)
        s"https://artifact.miloszjakubanis.com/repository/moon"
      else
        s"https://artifact.miloszjakubanis.com/repository/earth"
    })
  )
