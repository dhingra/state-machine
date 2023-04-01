package com.rd.strategy

/**
 * @author Rohit Dhingra
 */

fun interface Strategy<R, T> {
    fun transaction(payload: T ): R
}