name := "eth-fortune"

version := "0.1.0"

libraryDependencies ++= Seq(
  "com.mchange" %% "consuela" % "0.0.3" withSources()
)

sourceGenerators in Compile += Def.task {
  genstubs.StubGenerator.generate((sourceManaged in Compile).value)
}.taskValue
