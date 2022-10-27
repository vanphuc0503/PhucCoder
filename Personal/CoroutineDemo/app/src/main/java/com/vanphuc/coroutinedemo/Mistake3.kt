package com.vanphuc.coroutinedemo

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.withContext
import kotlin.random.Random

suspend fun doNetworkCall(): Result<String> {
    val result = netWorkCall()

    return if (result == "Success") {
        Result.success(result)
    } else {
        Result.failure(Exception())
    }
}

suspend fun netWorkCall(): String {
    return withContext(Dispatchers.IO) {
        delay(3000L)
        val random = Random
        random.nextBoolean()
        if (random.nextBoolean()) "Success" else "Error"
    }
}

/**
 * Mistake 3
 */
/*
suspend fun doNetworkCall() : Result<String> {
    val result = netWorkCall()
    return if(result == "Success") {
        Result.success(result)
    } else {
        Result.failure(Exception())
    }
}

suspend fun netWorkCall(): String {
    delay(3000L)
    return if(Random.nextBoolean()) "Success" else "Error"
}*/
