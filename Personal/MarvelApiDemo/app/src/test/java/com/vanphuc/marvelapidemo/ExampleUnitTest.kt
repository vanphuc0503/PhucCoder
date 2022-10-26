package com.vanphuc.marvelapidemo

import org.junit.Test

import org.junit.Assert.*
import java.math.BigInteger
import java.security.MessageDigest

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    @Test
    fun addition_isCorrect() {
        val ts = System.currentTimeMillis()
        println(ts)

        val input = "${ts}c6348924674fdc2e6493316f9630cce9306f9f4ed53304960eeaf1f3e5835b5872ed98fc"
        val md = MessageDigest.getInstance("MD5")
        println(BigInteger(1, md.digest(input.toByteArray())).toString(16).padStart(32, '0'))
    }
}