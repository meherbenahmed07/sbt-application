import sbt.Keys._
import sbt._

object Shared {
  def appName = "sbt-application"

  // Settings for the app, i.e. the root project
  val appSettings = settings(appName)

  // Add here more common dependencies:
  val commonDependencies = Seq(
  )
  // Settings for every service, i.e. for backend module
  def serviceSettings(module: String) = moduleSettings(module) ++: Seq()

  // Settings for every module, i.e. for every module
  def moduleSettings(module: String) = settings(module) ++: Seq(
  )

  // Common settings for every project
  def settings(theName: String) = Seq(
    name := theName,
    organization := "loyalcraft.org",
    version := "1.0-SNAPSHOT",
    scalaVersion := "2.11.7",
    doc in Compile <<= target.map(_ / "none"),
    scalacOptions in ThisBuild ++= Seq(
      "-target:jvm-1.8",
      "-encoding", "UTF-8",
      "-deprecation", // warning and location for usages of deprecated APIs
      "-feature", // warning and location for usages of features that should be imported explicitly
      "-unchecked", // additional warnings where generated code depends on assumptions
      "-language:reflectiveCalls",
      "-Xlint", // recommended additional warnings
      "-Ywarn-adapted-args", // Warn if an argument list is modified to match the receiver
      "-Ywarn-value-discard", // Warn when non-Unit expression results are unused
      "-Ywarn-inaccessible",
      "-Ywarn-dead-code"
    )
  )
}
