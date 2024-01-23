package org.cazait.cazaitandroid.core.repo.signin.network

import org.cazait.cazaitandroid.core.repo.signin.network.model.RefreshAccessTokenResponse
import org.cazait.cazaitandroid.core.repo.signin.network.model.SignInRequest
import org.cazait.cazaitandroid.core.repo.signin.network.model.SignInResponse
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.POST
import retrofit2.http.Query

internal interface SignInApi {
    @POST("/api/auths/log-in")
    suspend fun postSignIn(
        @Body
        signInRequest: SignInRequest,
        @Query("role")
        role: String = "user",
    ): SignInResponse

    @GET("/api/auths/refresh")
    suspend fun postRefreshAccessToken(
        @Header("Authorization")
        accessToken: String,
        @Header("Refresh-Token")
        refreshToken: String,
        @Query("role")
        role: String = "user",
    ): RefreshAccessTokenResponse

    companion object {
        fun createBearerHeader(accessToken: String): String = "Bearer $accessToken"
    }
}
