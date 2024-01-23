package org.cazait.cazaitandroid.core.repo.home.network

import org.cazait.cazaitandroid.core.repo.home.network.model.GetAllCongestionCafesResponse
import org.cazait.cazaitandroid.core.repo.home.network.model.GetAllFavoritedCafesResponse
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Path
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

    @GET("/api/favorites/user/{userId}")
    suspend fun getAllFavoritedCafes(
        @Header("Authorization")
        accessToken: String,
        @Path("userId")
        userId: String,
    ): GetAllFavoritedCafesResponse

    fun createTokenHeader(accessToken: String): String = "Bearer $accessToken"
}
