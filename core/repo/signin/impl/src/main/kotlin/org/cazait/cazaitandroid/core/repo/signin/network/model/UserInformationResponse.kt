package org.cazait.cazaitandroid.core.repo.signin.network.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
internal data class UserInformationResponse(
    @SerialName("id")
    val id: String,
    @SerialName("accountName")
    val accountName: String,
    @SerialName("accessToken")
    val accessToken: String,
    @SerialName("refreshToken")
    val refreshToken: String,
)
