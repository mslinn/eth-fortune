package genstubs

import java.io.File
import java.nio.file.Files
import scala.collection._
import scala.io.Codec

import com.mchange.sc.v1.consuela.ethereum.jsonrpc.Abi
import com.mchange.sc.v1.consuela.ethereum.stub.Generator

object StubGenerator {
  val packageDirName = "fortune"     

  def _generate : ( String, String ) = {
    val abi = Abi("""[{"constant":false,"inputs":[{"name":"fortune","type":"string"}],"name":"addFortune","outputs":[],"payable":false,"type":"function"},{"constant":true,"inputs":[],"name":"drawFortune","outputs":[{"name":"fortune","type":"string"}],"payable":false,"type":"function"},{"inputs":[{"name":"initialFortune","type":"string"}],"payable":false,"type":"constructor"}]""") // todo recommended way to run solc, in order to create ABI?
    val (className, code) = Generator.generateContractStub(
      baseClassName = "Fortune",
      abi = abi,
      async = true,
      fullyQualifiedPackageName = packageDirName 
    )
    ( className, code )   
  }

  def generate( srcDir : File ) : immutable.Seq[File] = {
    val packageDir = new File( srcDir, packageDirName ) // you'd have to do more work if this were a dot-separated path
    packageDir.mkdirs()
    val ( className, code ) = _generate
    val fileName = s"${className}.scala"
    val srcFile = new File( packageDir, fileName )
    Files.write( srcFile.toPath, code.getBytes( Codec.UTF8.charSet ) )
    immutable.Seq( srcFile )
  }
}
