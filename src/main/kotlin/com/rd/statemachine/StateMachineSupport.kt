package com.rd.statemachine

import java.lang.StringBuilder

/**
 * @author Rohit Dhingra
 */

abstract class StateMachineSupport<T> {
  constructor() {
    setup()
  }
  private val transition = mutableMapOf<String, T>()
  protected abstract fun setup()

  fun get(fromState: String?, toState: String?): T?{
    return transition[key(fromState,toState)]
  }


  protected fun transition(fromState: String?, toState: String?, item: T){
    val key = key(fromState, toState)
    if(transition[key] != null){
      println("transition from $fromState to $toState not allowed")
       throw RuntimeException("transition from $fromState to $toState not allowed")
    }
    transition[key] = item
  }

  private fun key(fromState: String?, toState: String?): String{
    return compositeKey(fromState?: "null", toState?: "null")
  }

  private fun compositeKey(vararg states: CharSequence): String{
    var result = StringBuilder();
    for(state in states){
      result.append(state)
      result.append("|")
    }
    result = result.delete(result.length-1, result.length)
    return result.toString()
  }



}