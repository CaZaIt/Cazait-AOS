package org.cazait.cazaitandroid.core.repo.signin.network

import org.cazait.cazaitandroid.core.repo.signin.network.model.SignInRequest
import org.cazait.cazaitandroid.core.repo.signin.network.model.SignInResponse
import retrofit2.http.Body
import retrofit2.http.POST

internal interface SignInApi {
    @POST("/api/auths/log-in")
    suspend fun postSignIn(
        @Body
        signInRequest: SignInRequest,
    ): SignInResponse
}
