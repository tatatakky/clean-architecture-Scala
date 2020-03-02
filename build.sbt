import sbt.Keys.libraryDependencies

lazy val base = "clean-Architecture"

organization := "com.github.tatatakky"

scalaVersion := "2.12.8"

scalacOptions += "-Ypartial-unification"

lazy val `entities` = (project in file("modules/entities")).
  settings(
    name := s"$base-entities",
  )

lazy val `usecases` = (project in file("modules/usecases")).
  settings(
    name := s"$base-usecases",
    libraryDependencies ++= Seq(
      Cats.core,
      CatsEffect.effect
    )
  ).dependsOn(entities)

lazy val `interfaces` = (project in file("modules/interfaces")).
  settings(
    name := s"$base-interfaces",
    libraryDependencies ++= Seq(
      Wvlet.airframe,
      Cats.core,
      CatsEffect.effect,
      Doobie.core
    )
  ).dependsOn(usecases)

lazy val `app` = (project in file("app")).
  settings(
    name := s"$base-app",
  ).dependsOn(interfaces)

lazy val root = (project in file(".")).
  settings(
    name := s"$base-root",
  ).
  aggregate(
    entities,
    usecases,
    interfaces,
    app
  )
