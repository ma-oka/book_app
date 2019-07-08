name := """library_app"""
organization := "com.example"

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayScala)

scalaVersion := "2.13.0"

libraryDependencies ++= Seq(
  guice,
  "mysql" % "mysql-connector-java" % "8.0.16",
  "org.scalatestplus.play" %% "scalatestplus-play" % "4.0.3" % Test
) ++ Seq(
  "org.scalikejdbc" %% "scalikejdbc"                  % "3.3.5",
  "org.scalikejdbc" %% "scalikejdbc-config"           % "3.3.5",
  "org.scalikejdbc" %% "scalikejdbc-play-initializer" % "2.7.1-scalikejdbc-3.3",
  "org.scalikejdbc" %% "scalikejdbc-test"                  % "3.3.5" % Test,
  "ch.qos.logback" % "logback-classic" % "1.2.3"
)

enablePlugins(FlywayPlugin)

import com.typesafe.config.ConfigFactory

val conf = ConfigFactory.parseFile(new File("./conf/application.conf"))

flywayUrl := conf.getString("db.default.url")
flywayUser := conf.getString("db.default.user")
flywayPassword := conf.getString("db.default.password")
flywayLocations := Seq("filesystem:./conf/db/migration/default")

flywayUrl in test := conf.getString("test.db.default.url")
flywayUser in test := conf.getString("test.db.default.user")
flywayPassword in test := conf.getString("test.db.default.password")
flywayLocations in test := Seq("filesystem:./conf/db/migration/default")