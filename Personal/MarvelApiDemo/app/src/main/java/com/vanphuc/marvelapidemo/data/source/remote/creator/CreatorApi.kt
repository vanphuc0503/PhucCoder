package com.vanphuc.marvelapidemo.data.source.remote.creator

import com.vanphuc.marvelapidemo.data.model.BaseResponse
import com.vanphuc.marvelapidemo.data.source.remote.enum_type.*
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query
import java.util.*

interface CreatorApi {
    @GET("/v1/public/creators")
    fun getCreators(
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
        @Query("events") events: Int? = null,
        @Query("stories") stories: Int? = null,
        @Query("orderBy") orderBy: CreatorsOrderByType? = null,
        @Query("limit") limit: Int? = null,
        @Query("offset") offset: Int? = null,
    ): Call<BaseResponse>?

    @GET("/v1/public/creators/{creatorId}")
    fun getCreatorById(
        @Path("creatorId") creatorId: Int,
    ): Call<BaseResponse>?

    @GET("/v1/public/creators/{creatorId}/comics")
    fun getComicsByCreatorID(
        @Path("creatorId") creatorId: Int,
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

    @GET("/v1/public/creators/{creatorId}/events")
    fun getEventsByCreatorID(
        @Path("creatorId") creatorId: Int,
        @Query("name") name: String? = null,
        @Query("nameStartsWith") nameStartsWith: String? = null,
        @Query("modifiedSince") modifiedSince: Date? = null,
        @Query("characters") characters: Int? = null,
        @Query("series") series: Int? = null,
        @Query("comics") comics: Int? = null,
        @Query("stories") stories: Int? = null,
        @Query("orderBy") orderBy: EventsOrderByType? = null,
        @Query("limit") limit: Int? = null,
        @Query("offset") offset: Int? = null
    ): Call<BaseResponse>?

    @GET("/v1/public/creators/{creatorId}/series")
    fun getSeriesByCreatorID(
        @Path("creatorId") creatorId: Int,
        @Query("title") title: String? = null,
        @Query("titleStartsWith") titleStartsWith: String? = null,
        @Query("startYear") startYear: Int? = null,
        @Query("modifiedSince") modifiedSince: Date? = null,
        @Query("characters") characters: Int? = null,
        @Query("comics") comics: Int? = null,
        @Query("stories") stories: Int? = null,
        @Query("events") events: Int? = null,
        @Query("seriesType") seriesType: SeriesType? = null,
        @Query("contains") contains: ContainsType? = null,
        @Query("orderBy") orderBy: SeriesOrderByType? = null,
        @Query("limit") limit: Int? = null,
        @Query("offset") offset: Int? = null
    ): Call<BaseResponse>?

    @GET("/v1/public/creators/{creatorId}/stories")
    fun getStoriesByCreatorID(
        @Path("creatorId") creatorId: Int,
        @Query("modifiedSince") modifiedSince: Date? = null,
        @Query("comics") comics: Int? = null,
        @Query("series") series: Int? = null,
        @Query("events") events: Int? = null,
        @Query("characters") characters: Int? = null,
        @Query("orderBy") orderBy: StoriesOrderByType? = null,
        @Query("limit") limit: Int? = null,
        @Query("offset") offset: Int? = null
    ): Call<BaseResponse>?
}