package com.rd

import com.rd.model.Payload
import com.rd.strategy.TransactionStrategyContext

/**
 * @author Rohit Dhingra
 */

fun main (args: Array<String>){
    val transactionStrategyContext = TransactionStrategyContext()
    val strategy = transactionStrategyContext.onStrategyA("A", "B" , PayloadDemo("A", "Payload of A"))
    println(strategy?.data)
    val strategy2 = transactionStrategyContext.onStrategyA(null, "A" , PayloadDemo("A", "Payload of A"))
    println(strategy2?.data)
  }

 data class PayloadDemo(
   override val id: String,
   override val data: String
 ) : Payload




