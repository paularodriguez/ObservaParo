name := "ObservaParo"

version := "1.0-SNAPSHOT"

libraryDependencies ++= Seq(
  javaJdbc,
  javaEbean,
  cache,
  "org.apache.poi" % "poi-ooxml" % "3.9",
  "org.assertj" % "assertj-core" % "1.5.0" % "test",
  "com.google.inject" % "guice" % "3.0" % "test",
  "info.cukes" % "cucumber-guice" % "1.1.5" % "test",
  "info.cukes" % "cucumber-java" % "1.1.5" % "test",
  "info.cukes" % "cucumber-junit" % "1.1.5" % "test"
)     

play.Project.playJavaSettings

unmanagedResourceDirectories in Test <+= baseDirectory( _ / "features" )