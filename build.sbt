name := "UnitTestMetadataAPIService"

version := "0.1"

scalaVersion := "2.10.0"

scalacOptions := List ("-unchecked", "-deprecation", "-encoding", "utf8")

(testOptions in Test) += Tests.Argument(TestFrameworks.ScalaTest, "-h", "target/report")

resolvers += "Typesafe Repo" at "http://repo.typesafe.com/typesafe/releases/"

libraryDependencies ++= List (
  "com.typesafe.play" %% "play-json" % "2.2.1",
  "org.pegdown" % "pegdown" % "1.4.2",
  "com.github.dreamhead" % "moco-core" % "0.7",
  "net.databinder.dispatch" %% "dispatch-core" % "0.11.0",
  "org.scalatest" % "scalatest_2.10" % "2.0"
)