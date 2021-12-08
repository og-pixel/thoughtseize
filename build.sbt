lazy val SCALA_3 = "3.1.0"
lazy val SCALA_2 = "2.13.7"


lazy val thoughtseize: Project = project.in(file("."))
  .settings(
    name := "Thoughtseize",
    organizationName := "Milosz Jakubanis",
    version := "0.0.1",
    scalaVersion := SCALA_2,
    organization := "com.miloszjakubanis",
    libraryDependencies ++= Seq(
      "com.typesafe" % "config" % "1.4.1",
      "com.lihaoyi" %% "utest" % "0.7.0" % Test
    ),
    testFrameworks += new TestFramework("utest.runner.Framework"),
    scalacOptions ++= Seq(
      "-feature",
      "-language:implicitConversions",
      "-deprecation",
      "-unchecked"
//      "-Yexplicit-nulls",
//      "-Ysafe-init",
//      "-new-syntax",
    )
  )
