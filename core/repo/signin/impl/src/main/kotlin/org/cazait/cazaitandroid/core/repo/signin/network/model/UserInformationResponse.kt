package org.cazait.cazaitandroid.core.repo.signin.network.model

import kotlinx.serialization.Serializable

@Serializable
internal data class UserInformationResponse(
    val id: String,
    val accountName: String,
    val accessToken: String,
    val refreshToken: String,
)
