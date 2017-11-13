name := "eth-fortune"

version := "0.0.1-SNAPSHOT"

ethJsonRpcUrl := "http://localhost:8545"

ethPackageScalaStubs := "com.mchange.test"

libraryDependencies ++= Seq(
  "com.mchange" %% "consuela" % "0.0.3" withSources()
)
