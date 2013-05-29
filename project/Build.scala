import sbt._
import Keys._

object ApplicationBuild extends Build {

  val appName         = "numerals-to-string"
  val appVersion      = "1.0-SNAPSHOT"
	scalaVersion in ThisBuild := "2.10.1"
	scalacOptions in ThisBuild ++= Seq("-feature", "-deprecation", "-XX:MaxPermSize=256M")
	parallelExecution in Test := false

  val appDependencies = Seq()

  unmanagedBase <<= baseDirectory { base => base / "lib" }

  val buildSettings = Defaults.defaultSettings ++ Seq()

	val main = Project(appName, file("."), settings = buildSettings)
}
