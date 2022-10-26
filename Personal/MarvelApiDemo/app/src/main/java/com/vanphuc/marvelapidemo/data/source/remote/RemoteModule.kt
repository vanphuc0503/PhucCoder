package com.vanphuc.marvelapidemo.data.source.remote

import com.vanphuc.marvelapidemo.data.source.remote.character.CharacterApi
import com.vanphuc.marvelapidemo.data.source.remote.comic.ComicApi
import com.vanphuc.marvelapidemo.data.source.remote.event.EventApi
import com.vanphuc.marvelapidemo.data.source.remote.series.SeriesApi
import com.vanphuc.marvelapidemo.data.source.remote.story.StoryApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(ActivityComponent::class)
object RemoteModule {

    @Provides
    @Singleton
    fun provideRetrofit(
        // Potential dependencies of this type
    ): Retrofit {
        return Retrofit.Builder()
            .baseUrl("http://gateway.marvel.com")
            .build()
    }

    @Provides
    fun provideCharacterApi(retrofit: Retrofit): CharacterApi = retrofit.create(CharacterApi::class.java)

    @Provides
    @Singleton
    fun provideComicApi(retrofit: Retrofit): ComicApi = retrofit.create(ComicApi::class.java)

    @Provides
    @Singleton
    fun provideEventApi(retrofit: Retrofit): EventApi = retrofit.create(EventApi::class.java)

    @Provides
    @Singleton
    fun provideSeriesApi(retrofit: Retrofit): SeriesApi = retrofit.create(SeriesApi::class.java)

    @Provides
    @Singleton
    fun provideStoryApi(retrofit: Retrofit): StoryApi = retrofit.create(StoryApi::class.java)
}