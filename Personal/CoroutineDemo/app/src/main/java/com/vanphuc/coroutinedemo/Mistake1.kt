package com.vanphuc.coroutinedemo

import kotlinx.coroutines.*

suspend fun getUserFirstNames(userIds: List<String>): List<String> {
    val firstNames = mutableListOf<Deferred<String>>()
    coroutineScope {
        for (id in userIds) {
            val firstName = async {
                getFirstName(id)
            }
            firstNames.add(firstName)
        }
    }
    return firstNames.awaitAll()
}

suspend fun getFirstName(userId: String): String {
    delay(1000)
    return "First name"
}

/**
 * Mistake 1: avoid running sequentially
 */
/*
suspend fun getUserFirstNames(userIds: List<String>): List<String> {
    val firstNames = mutableListOf<String>()
    for (id in userIds) {
        firstNames.add(getFirstName(id))
    }
    return firstNames
}

suspend fun getFirstName(userId: String): String {
    delay(1000)

  return "First name"
}*/
