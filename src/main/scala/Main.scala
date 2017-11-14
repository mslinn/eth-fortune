import fortune._

import scala.concurrent.Await
import scala.concurrent.duration.Duration
import com.mchange.sc.v1.consuela.ethereum.{jsonrpc,EthAddress,stub}
import jsonrpc.Invoker

// global implicits
import scala.concurrent.ExecutionContext.Implicits.global
import jsonrpc.Client.Factory.Default
import com.mchange.sc.v2.concurrent.Poller.Default

// case class AsyncFortune( val contractAddress : EthAddress )( implicit icontext : jsonrpc.Invoker.Context, cfactory : jsonrpc.Client.Factory, poller : Poller, econtext : ExecutionContext )

object Main extends App {
  // config basically
  implicit val icontext = Invoker.Context( args(0) )

  // who is interacting with the stubs? we're accessing a read-only method that is
  // independent of sender, so who cares?
  implicit val sender = stub.Sender.Default
  
  val fortuneContract = AsyncFortune( EthAddress( "0xcf547d5909b3c39e98bb54107f3320f60df01609" ) )
  println( Await.result( fortuneContract.constant.drawFortune(), Duration.Inf ) )
}
