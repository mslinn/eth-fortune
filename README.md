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

    $ sbt "run something"

todo Steve: what is that special something?
