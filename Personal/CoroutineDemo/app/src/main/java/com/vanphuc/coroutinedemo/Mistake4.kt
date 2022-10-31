package com.vanphuc.coroutinedemo

import kotlinx.coroutines.CancellationException
import kotlinx.coroutines.delay

suspend fun riskyTask() {
    try {
        delay(3000L)
        println("The answer is ${10/0}")
    } catch (e: Exception) {
        if (e is CancellationException) {
            throw e
        }
        println("Oop, that didn't work")
    }
}

/**
 * Mistake 4
 */
/*suspend fun riskyTask() {
    try {
        delay(3000L)
        println("The answer is ${10/0}")
    } catch (e: Exception) {
        println("Oop, that didn't work")
    }
}*/
