import com.mchange.sc.v1.consuela.ethereum.jsonrpc.Abi
import com.mchange.sc.v1.consuela.ethereum.stub.Generator

object Main extends App {
  val abi = Abi("") // todo recommended way to run solc, in order to create ABI?
  val x = Generator.generateContractStub(
    baseClassName = "Fortune",
    abi=abi,
    async = true,
    fullyQualifiedPackageName = "com.mchange.test"
  )
}
