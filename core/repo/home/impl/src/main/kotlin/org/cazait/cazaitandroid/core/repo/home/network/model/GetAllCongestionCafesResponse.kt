package org.cazait.cazaitandroid.core.repo.home.network.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class GetAllCongestionCafesResponse(
    @SerialName("code")
    val code: Int,
    @SerialName("result")
    val result: String,
    @SerialName("message")
    val message: String,
    @SerialName("data")
    val data: List<List<CongestionCafeResponse>>,
)
