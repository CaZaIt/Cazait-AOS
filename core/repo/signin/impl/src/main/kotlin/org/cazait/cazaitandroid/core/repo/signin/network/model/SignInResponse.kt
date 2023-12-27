package org.cazait.cazaitandroid.core.repo.signin.network.model

import kotlinx.serialization.Serializable

@Serializable
internal data class SignInResponse(
    val code: Int,
    val result: String,
    val message: String,
    val data: UserInformationResponse,
)
