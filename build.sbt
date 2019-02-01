Shared.appSettings

lazy val Entity = (project in file("modules/Entity")).enablePlugins(PlayScala)

lazy val Repository = (project in file("modules/Repository")).enablePlugins(PlayScala).dependsOn(Entity)

lazy val Services = (project in file("modules/Services")).enablePlugins(PlayScala).dependsOn(Entity, Repository)

lazy val Controllers = (project in file("modules/Controllers")).enablePlugins(PlayScala).dependsOn( Entity, Repository, Services)

lazy val root = (project in file(".")).enablePlugins(PlayScala)
  .aggregate( Entity, Repository, Services, Controllers)
  .dependsOn( Entity, Repository, Services, Controllers)

libraryDependencies ++= Shared.commonDependencies

libraryDependencies ++= Seq(
  jdbc,
  cache,
  ws,
  "org.scalatestplus.play" %% "scalatestplus-play" % "1.5.1" % Test
)

