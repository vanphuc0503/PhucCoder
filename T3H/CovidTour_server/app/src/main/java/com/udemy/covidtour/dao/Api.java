package com.udemy.covidtour.dao;

import com.google.gson.JsonObject;
import com.udemy.covidtour.model.User;

import io.reactivex.rxjava3.core.Single;
import okhttp3.MultipartBody;
import okhttp3.ResponseBody;
import retrofit2.http.Body;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.Query;

public interface Api {
    @POST("user-register.php")
    Single<ResponseBody> register(@Body JsonObject body);

    @POST("user-login.php")
    Single<User> login(@Body JsonObject body);

    @Multipart
    @POST("user-edit.php")
    Single<ResponseBody> editUser(
            @Query("email") String email,
            @Query("name") String name,
            @Query("dob") String dob,
            @Query("phone") String phone,
            @Query("sex") boolean sex,
            @Query("password") String password,
            @Query("avatar") String avatar,
            @Part("avatar") MultipartBody.Part file
            );
}
