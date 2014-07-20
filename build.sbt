name := "dumper"

version := "1.0"

scalaVersion := "2.9.2"

resolvers += "Sonatype OSS Snapshots" at "https://oss.sonatype.org/content/repositories/snapshots"

resolvers += "Sonatype OSS Releases" at "https://oss.sonatype.org/content/repositories/releases"

libraryDependencies += "org.mongodb" %% "casbah" % "2.6.5"

libraryDependencies += "org.skife.com.typesafe.config" % "typesafe-config" % "0.3.0"

