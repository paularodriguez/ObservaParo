name := "ObservaParo"

version := "1.0-SNAPSHOT"

libraryDependencies ++= Seq(
  javaJdbc,
  javaEbean,
  cache,
  "org.apache.poi" % "poi-ooxml" % "3.9"
)     

play.Project.playJavaSettings
