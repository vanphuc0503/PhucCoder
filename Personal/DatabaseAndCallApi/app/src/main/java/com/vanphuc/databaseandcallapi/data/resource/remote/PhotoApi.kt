package com.vanphuc.databaseandcallapi.data.resource.remote

import com.vanphuc.databaseandcallapi.data.model.Photo
import retrofit2.Call
import retrofit2.http.GET

interface PhotoApi {
    @GET("/photos")
    fun listPhoto(): Call<List<Photo>>
}