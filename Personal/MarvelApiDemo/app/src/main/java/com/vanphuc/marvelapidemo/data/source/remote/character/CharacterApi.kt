package com.vanphuc.marvelapidemo.data.source.remote.character

import com.vanphuc.marvelapidemo.data.model.BaseResponse
import com.vanphuc.marvelapidemo.data.source.remote.enum_type.*
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query
import java.util.*

interface CharacterApi {
    @GET("/v1/public/characters")
    fun getCharacters(
        @Query("name") name: String? = null,
        @Query("nameStartsWith") nameStartsWith: String? = null,
        @Query("modifiedSince") modifiedSince: Date? = null,
        @Query("comics") comics: Int? = null,
        @Query("series") series: Int? = null,
        @Query("events") events: Int? = null,
        @Query("stories") stories: Int? = null,
        @Query("orderBy") orderBy: CharactersOrderByType? = null, //name, modified, -name, -modified
        @Query("limit") limit: Int? = null,
        @Query("offset") offset: Int? = null,
    ): Call<BaseResponse>?

    @GET("/v1/public/characters/{characterId}")
    fun getCharactersById(
        @Path("characterId") characterId: Int,
    ): Call<BaseResponse>?

    @GET("/v1/public/characters/{characterId}/comics")
    fun getComicsByCharacterID(
        @Path("characterId") characterId: Int,
        @Query("format") format: FormatType? = null,
        @Query("formatType") formatType: FormatCategoryType? = null,
        @Query("noVariants") noVariants: Boolean? = null,
        @Query("dateDescriptor") dateDescriptor: DateDescriptorType? = null,
        @Query("dateRange") dateRange: Date? = null,
        @Query("title") title: String? = null,
        @Query("titleStartsWith") titleStartsWith: String? = null,
        @Query("startYear") startYear: Int? = null,
        @Query("issueNumber") issueNumber: String? = null,
        @Query("diamondCode") diamondCode: String? = null,
        @Query("digitalId") digitalId: Int? = null,
        @Query("upc") upc: String? = null,
        @Query("isbn") isbn: String? = null,
        @Query("ean") ean: String? = null,
        @Query("issn") issn: String? = null,
        @Query("hasDigitalIssue") hasDigitalIssue: Boolean? = null,
        @Query("modifiedSince") modifiedSince: Date? = null,
        @Query("creators") creators: Int? = null,
        @Query("series") series: Int? = null,
        @Query("events") events: Int? = null,
        @Query("stories") stories: Int? = null,
        @Query("sharedAppearances") sharedAppearances: Int? = null,
        @Query("collaborators") collaborators: Int? = null,
        @Query("orderBy") orderBy: ComicsOrderByType? = null,
        @Query("limit") limit: Int? = null,
        @Query("offset") offset: Int? = null,
    ): Call<BaseResponse>?

    @GET("/v1/public/characters/{characterId}/events")
    fun getEventsByCharacterID(
        @Path("characterId") characterId: Int,
        @Query("name") name: String? = null,
        @Query("nameStartsWith") nameStartsWith: String? = null,
        @Query("modifiedSince") modifiedSince: Date? = null,
        @Query("creators") creators: Int? = null,
        @Query("series") series: Int? = null,
        @Query("comics") comics: Int? = null,
        @Query("stories") stories: Int? = null,
        @Query("orderBy") orderBy: EventsOrderByType? = null,
        @Query("limit") limit: Int? = null,
        @Query("offset") offset: Int? = null
    ): Call<BaseResponse>?

    @GET("/v1/public/characters/{characterId}/series")
    fun getSeriesByCharacterID(
        @Path("characterId") characterId: Int,
        @Query("title") title: String? = null,
        @Query("titleStartsWith") titleStartsWith: String? = null,
        @Query("startYear") startYear: Int? = null,
        @Query("modifiedSince") modifiedSince: Date? = null,
        @Query("creators") creators: Int? = null,
        @Query("comics") comics: Int? = null,
        @Query("stories") stories: Int? = null,
        @Query("events") events: Int? = null,
        @Query("seriesType") seriesType: SeriesType? = null,
        @Query("contains") contains: ContainsType? = null,
        @Query("orderBy") orderBy: SeriesOrderByType? = null,
        @Query("limit") limit: Int? = null,
        @Query("offset") offset: Int? = null
    ): Call<BaseResponse>?

    @GET("GET /v1/public/characters/{characterId}/stories")
    fun getStoriesByCharacterID(
        @Path("characterId") characterId: Int,
        @Query("modifiedSince") modifiedSince: Date? = null,
        @Query("comics") comics: Int? = null,
        @Query("series") series: Int? = null,
        @Query("events") events: Int? = null,
        @Query("creators") creators: Int? = null,
        @Query("orderBy") orderBy: StoriesOrderByType? = null,
        @Query("limit") limit: Int? = null,
        @Query("offset") offset: Int? = null
    ): Call<BaseResponse>?
}