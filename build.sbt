name := "dumper"

version := "1.0"

scalaVersion := "2.9.2"

resolvers += "Sonatype OSS Snapshots" at "https://oss.sonatype.org/content/repositories/snapshots"

resolvers += "Sonatype OSS Releases" at "https://oss.sonatype.org/content/repositories/releases"

resolvers += Resolver.sonatypeRepo("public")

libraryDependencies += "org.mongodb" %% "casbah" % "2.6.5"

libraryDependencies += "org.skife.com.typesafe.config" % "typesafe-config" % "0.3.0"

libraryDependencies += "com.github.scopt" %% "scopt" % "3.2.0"

