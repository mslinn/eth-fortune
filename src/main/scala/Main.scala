import com.mchange.sc.v1.consuela.ethereum.jsonrpc.Invoker
import com.mchange.sc.v1.consuela.ethereum.stub.Sender
import com.mchange.sc.v1.consuela.ethereum.{EthAddress, jsonrpc, stub}
import fortune._
import scala.concurrent.Await
import scala.concurrent.duration.Duration

// global implicits
import com.mchange.sc.v1.consuela.ethereum.jsonrpc.Client.Factory.Default
import com.mchange.sc.v2.concurrent.Poller.Default
import scala.concurrent.ExecutionContext.Implicits.global

// case class AsyncFortune( val contractAddress : EthAddress )( implicit iContext : jsonrpc.Invoker.Context, cfactory : jsonrpc.Client.Factory, poller : Poller, econtext : ExecutionContext )

object Main extends App {
  // Config basically
  implicit val iContext: Invoker.Context = Invoker.Context( args(0) )

  // Who is interacting with the stubs? We're accessing a read-only method that is
  // independent of sender, so who cares?
  implicit val sender: Sender.Basic = stub.Sender.Default

  val fortuneContract = AsyncFortune( EthAddress( "0xcf547d5909b3c39e98bb54107f3320f60df01609" ) )
  println( Await.result( fortuneContract.constant.drawFortune, Duration.Inf ) )
}
