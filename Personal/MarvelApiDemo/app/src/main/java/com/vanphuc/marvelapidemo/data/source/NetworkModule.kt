package com.vanphuc.marvelapidemo.data.source

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @AuthInterceptorOkHttpClient
    @Provides
    @Singleton
    fun provideAuthInterceptorOkHttpClient(
//        authInterceptor: AuthInterceptor
    ): OkHttpClient {
        return OkHttpClient.Builder()
//            .addInterceptor(authInterceptor)
            .build()
    }

    @OtherInterceptorOkHttpClient
    @Provides
    @Singleton
    fun provideOtherInterceptorOkHttpClient(
//        otherInterceptor: OtherInterceptor
    ): OkHttpClient {
        return OkHttpClient.Builder()
//            .addInterceptor(otherInterceptor)
            .build()
    }
}
