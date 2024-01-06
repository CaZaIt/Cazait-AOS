package org.cazait.cazaitandroid.core.repo.cafedetail.network

import org.cazait.cazaitandroid.core.repo.cafedetail.network.model.GetCafeMenusResponse
import org.cazait.cazaitandroid.core.repo.cafedetail.network.model.GetCafeReviewsResponse
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

internal interface CafeDetailApi {
    @GET("/api/menus/cafe/{cafeId}")
    suspend fun getCafeMenus(
        @Path("cafeId")
        cafeId: String
    ): GetCafeMenusResponse

    @GET("/api/reviews/{cafeId}")
    suspend fun getCafeReviews(
        @Path("cafeId")
        cafeId: String,
        @Query("sortBy")
        sortBy: String,
        @Query("index")
        index: Int,
        @Query("nums")
        nums: Int,
    ): GetCafeReviewsResponse
}