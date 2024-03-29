package org.cazait.cazaitandroid.core.repo.signin.network.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
internal data class SignInResponse(
    @SerialName("code")
    val code: Int,
    @SerialName("result")
    val result: String,
    @SerialName("message")
    val message: String,
    @SerialName("data")
    val data: UserInformationResponse,
)
