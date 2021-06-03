lazy val SCALA_3 = "3.0.0"

lazy val thoughtseize: Project = Project("thoughtseize", file("."))
  .settings(
    name := "Thoughtseize",
    organizationName := "Milosz Jakubanis",
    version := "0.0.1",
    scalaVersion := SCALA_3,
    organization := "com.miloszjakubanis",
    libraryDependencies ++= Seq(
      "com.lihaoyi" %% "utest" % "0.7.10" % Test,
    ),
    testFrameworks += new TestFramework("utest.runner.Framework"),
    scalacOptions ++= Seq(
      "-feature",
      "-language:implicitConversions",
      "-deprecation",
      "-unchecked",
      "-Yexplicit-nulls",
      "-Ysafe-init",
      "-new-syntax",
    )
  )
