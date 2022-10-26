package com.vanphuc.marvelapidemo.data.source.remote.comic

import com.vanphuc.marvelapidemo.data.model.BaseResponse
import com.vanphuc.marvelapidemo.data.source.remote.enum_type.*
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query
import java.util.*

interface ComicApi {
    @GET("/v1/public/comics")
    fun getComics(
        @Query("format") format: FormatType? = null,
        @Query("formatType") formatType: FormatCategoryType? = null,
        @Query("noVariants") noVariants: Boolean? = null,
        @Query("dateDescriptor") dateDescriptor: DateDescriptorType? = null,
        @Query("dateRange") dateRange: Date? = null,
        @Query("title") title: String? = null,
        @Query("titleStartsWith") titleStartsWith: String? = null,
        @Query("startYear") startYear: Int? = null, //name, modified, -name, -modified
        @Query("issueNumber") issueNumber: Int? = null,
        @Query("diamondCode") diamondCode: String? = null,
        @Query("digitalId") digitalId: Int? = null,
        @Query("upc") upc: String? = null,
        @Query("isbn") isbn: String? = null,
        @Query("ean") ean: String? = null,
        @Query("issn") issn: String? = null,
        @Query("hasDigitalIssue") hasDigitalIssue: Boolean? = null,
        @Query("modifiedSince") modifiedSince: Date? = null,
        @Query("creators") creators: Int? = null,
        @Query("characters") characters: Int? = null,
        @Query("series") series: Int? = null,
        @Query("events") events: Int? = null,
        @Query("stories") stories: Int? = null,
        @Query("sharedAppearances") sharedAppearances: Int? = null,
        @Query("collaborators") collaborators: Int? = null,
        @Query("orderBy") orderBy: ComicsOrderByType? = null,
        @Query("limit") limit: Int? = null,
        @Query("offset") offset: Int? = null,
    ): Call<BaseResponse>?

    @GET("/v1/public/comics/{comicId}")
    fun getComicsById(
        @Path("comicId") comicId: Int,
    ): Call<BaseResponse>?

    @GET("/v1/public/comics/{comicId}/characters")
    fun getCharactersByComicID(
        @Path("comicId") comicId: Int,
        @Query("name") name: String? = null,
        @Query("nameStartsWith") nameStartsWith: String? = null,
        @Query("modifiedSince") modifiedSince: Date? = null,
        @Query("series") series: Int? = null,
        @Query("events") events: Int? = null,
        @Query("stories") stories: Int? = null,
        @Query("orderBy") orderBy: CharactersOrderByType? = null,
        @Query("limit") limit: Int? = null,
        @Query("offset") offset: Int? = null
    ): Call<BaseResponse>?

    @GET("/v1/public/comics/{comicId}/creators")
    fun getCreatorsByComicID(
        @Path("comicId") comicId: Int,
        @Query("firstName") firstName: String? = null,
        @Query("middleName") middleName: String? = null,
        @Query("lastName") lastName: String? = null,
        @Query("suffix") suffix: String? = null,
        @Query("nameStartsWith") nameStartsWith: String? = null,
        @Query("firstNameStartsWith") firstNameStartsWith: String? = null,
        @Query("middleNameStartsWith") middleNameStartsWith: String? = null,
        @Query("lastNameStartsWith") lastNameStartsWith: String? = null,
        @Query("modifiedSince") modifiedSince: Date? = null,
        @Query("comics") comics: Int? = null,
        @Query("series") series: Int? = null,
        @Query("stories") stories: Int? = null,
        @Query("orderBy") orderBy: CreatorsOrderByType? = null,
        @Query("limit") limit: Int? = null,
        @Query("offset") offset: Int? = null
    ): Call<BaseResponse>?

    @GET("/v1/public/comics/{comicId}/events")
    fun getEventsByComicID(
        @Path("comicId") comicId: Int,
        @Query("name") name: String? = null,
        @Query("nameStartsWith") nameStartsWith: String? = null,
        @Query("modifiedSince") modifiedSince: Date? = null,
        @Query("creators") creators: Int? = null,
        @Query("characters") characters: Int? = null,
        @Query("series") series: Int? = null,
        @Query("stories") stories: Int? = null,
        @Query("orderBy") orderBy: EventsOrderByType? = null,
        @Query("limit") limit: Int? = null,
        @Query("offset") offset: Int? = null
    ): Call<BaseResponse>?

    @GET("/v1/public/comics/{comicId}/stories")
    fun getStoriesByComicID(
        @Path("comicId") comicId: Int,
        @Query("modifiedSince") modifiedSince: Date? = null,
        @Query("events") events: Int? = null,
        @Query("series") series: Int? = null,
        @Query("characters") characters: Int? = null,
        @Query("creators") creators: Int? = null,
        @Query("orderBy") orderBy: StoriesOrderByType? = null,
        @Query("limit") limit: Int? = null,
        @Query("offset") offset: Int? = null
    ): Call<BaseResponse>?
}