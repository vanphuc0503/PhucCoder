package com.vanphuc.datastorage

interface MainActivityListener {
    fun saveData()
    fun saveDataByCache()
    fun readData()
    fun readDataByCache()
}