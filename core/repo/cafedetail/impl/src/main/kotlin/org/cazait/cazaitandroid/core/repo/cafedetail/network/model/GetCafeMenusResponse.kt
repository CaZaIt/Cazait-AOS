package org.cazait.cazaitandroid.core.repo.cafedetail.network.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
internal data class GetCafeMenusResponse(
    @SerialName("code")
    val code: Int,
    @SerialName("result")
    val result: String,
    @SerialName("message")
    val message: String,
    @SerialName("data")
    val data: List<CafeMenuResponse>
)