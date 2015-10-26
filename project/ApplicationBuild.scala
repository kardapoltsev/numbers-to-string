import sbt._
import Keys._

object ApplicationBuild extends Build {

  val appName         = "numbers-to-string"
  val appVersion      = "1.0-SNAPSHOT"

  val appDependencies = Seq(
    // testing libs
    "org.scalatest" %% "scalatest" % "2.2.5" % "test"
  )

  val buildSettings = Seq(scalaVersion := "2.11.7",
      version := "1.0-SNAPSHOT",
      libraryDependencies ++= appDependencies)

	val main = Project(appName, file("."), settings = buildSettings)
}
