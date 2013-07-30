import sbt._
import Keys._

object ApplicationBuild extends Build {

  val appName         = "numbers-to-string"
  val appVersion      = "1.0-SNAPSHOT"
//	scalaVersion in ThisBuild := "2.10.0"
//	scalacOptions in ThisBuild ++= Seq("-feature", "-deprecation", "-XX:MaxPermSize=256M")
//	parallelExecution in Test := false
//
//  unmanagedBase <<= baseDirectory { base => base / "lib" }

  val appDependencies = Seq(
    // testing libs
    "org.scalatest" %% "scalatest" % "1.9" % "test",
    "org.specs2" %% "specs2" % "1.14" % "test")

  val buildSettings = Defaults.defaultSettings ++
    Seq(scalaVersion := "2.10.1",
      version := "1.0-SNAPSHOT",
      libraryDependencies ++= appDependencies)

	val main = Project(appName, file("."), settings = buildSettings)
}
