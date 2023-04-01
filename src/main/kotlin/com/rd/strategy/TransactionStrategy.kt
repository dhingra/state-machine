package com.rd.strategy

import com.rd.model.Payload
/**
 * @author Rohit Dhingra
 */

fun interface TransactionStrategy: Strategy<Payload, Payload>
