name := "hackerrank-challenges"

organization := "hackerrank"

version := "1.0"

scalaVersion := "2.11.8"

libraryDependencies ++= Seq(
  "org.scalatest" %% "scalatest" % "3.0.0" % "test",
  "org.mockito" % "mockito-core" % "1.10.19" % "test",
  "com.fasterxml.jackson.core" % "jackson-databind" % "2.8.4"
)

scalacOptions ++= Seq("-feature", "-unchecked", "-deprecation", "-encoding", "utf8")

initialCommands := "import hackerrank._"