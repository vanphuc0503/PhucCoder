package com.vanphuc.coroutinedemo

import kotlinx.coroutines.*
import kotlin.random.Random

suspend fun doSomething() {
    val job = CoroutineScope(Dispatchers.Default).launch {
        var random = Random.nextInt(100_000)
        while (random != 50000 /*&& isActive */) {
            random = Random.nextInt(100_000)
            ensureActive() // way 2
        }
    }
    delay(500L)
    job.cancel()
}

/**
 * Mistake 2
 */
/*
suspend fun doSomething() {
    val job = CoroutineScope(Dispatchers.Default).launch {
        var random = Random.nextInt(100_000)
        while (random != 50000) {
            random = Random.nextInt(100_000)
        }
    }
    delay(500L)
    job.cancel()
}*/
