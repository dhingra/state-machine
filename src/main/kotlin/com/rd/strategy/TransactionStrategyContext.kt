package com.rd.strategy

import com.rd.PayloadDemo
import com.rd.model.Payload
import com.rd.statemachine.StateMachineSupport

/**
 * @author Rohit Dhingra
 */

class TransactionStrategyContext {

  companion object {
    private val STRATEGY_A_STATE_A =  TransactionStrategy { _ ->
      val p = PayloadDemo("B","Payload when Null -> A")
      p
    }

    private val STRATEGY_A_STATE_B =  TransactionStrategy { _ ->
      val p = PayloadDemo("B","Payload when A -> B")
      p
    }

    private val STRATEGY_A_STATE_C =  TransactionStrategy { _ ->
      val p = PayloadDemo("C","Payload when A -> C")
      p
    }

    private val STRATEGY_B_STATE_B =  TransactionStrategy { payload -> payload }
  }

  private val STRATEGY_A = object: StateMachineSupport<Strategy<Payload,Payload>>(){
    override fun setup() {
      transition(null, "A", STRATEGY_A_STATE_A)
      transition("A", "B", STRATEGY_A_STATE_B)
      transition("A", "C", STRATEGY_A_STATE_C)
    }
  }

  fun onStrategyA(fromState:String?, toState: String?, item: Payload): Payload?{
    val strategy = STRATEGY_A.get(fromState, toState)
    return strategy?.transaction(item)
  }
}