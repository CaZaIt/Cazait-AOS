package org.cazait.cazaitandroid.core.repo.home.network

import org.cazait.cazaitandroid.core.repo.home.network.model.GetAllCongestionCafesResponse
import retrofit2.http.GET
import retrofit2.http.Query

internal interface HomeApi {
    @GET("api/cafes/all")
    suspend fun getAllCongestionCafes(
        @Query("latitude")
        latitude: String,
        @Query("longitude")
        longitude: String,
        @Query("sort")
        sort: String,
        @Query("limit")
        limit: String,
    ): GetAllCongestionCafesResponse
}