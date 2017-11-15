# eth-fortune

An example of how [Consuela](https://github.com/swaldman/consuela) can be used to generate Scala wrappers for Ethereum Solidity contracts.
There is someone behind the curtain. Pay no attention...

## Where is the Magic?
Consuela translated the Solidity contract in 
[src/main/solidity/Fortune.sol](https://github.com/mslinn/eth-fortune/blob/master/src/main/solidity/Fortune.sol) 
to 
[project/src/main/scala/codegen/GenSubs.scala](https://github.com/mslinn/eth-fortune/blob/master/project/src/main/scala/codegen/GenStubs.scala).
The [Main program](https://github.com/mslinn/eth-fortune/blob/master/src/main/scala/Main.scala),
written in Scala, can transact using the contract.

## Running the Program
If you are running a local Ethereum network, connect to it like this:

    $ sbt "run http://localhost:8545"

if you are using infura, and your token is `XXXXXXX`, the incantation would be something like:

    $ sbt "run https://mainnet.infura.io/XXXXXXX"
