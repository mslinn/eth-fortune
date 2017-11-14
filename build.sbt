name := "eth-fortune"

version := "0.0.1-SNAPSHOT"

libraryDependencies ++= Seq(
  "com.mchange" %% "consuela" % "0.0.3" withSources()
)

sourceGenerators in Compile += Def.task {
  genstubs.StubGenerator.generate((sourceManaged in Compile).value)
}.taskValue



