package org.cazait.cazaitandroid.core.repo.cafedetail.network.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
internal data class CafeReviewResponse(
    @SerialName("userId")
    val userId: String,
    @SerialName("reviewId")
    val reviewId: String,
    @SerialName("cafeName")
    val cafeName: String,
    @SerialName("nickname")
    val nickname: String,
    @SerialName("score")
    val score: Int,
    @SerialName("content")
    val content: String,
)

@Serializable
internal data class CafeReviewResponses(
    @SerialName("reviewResponses")
    val reviewResponses: List<CafeReviewResponse>,
    @SerialName("totalElements")
    val totalElements: Int,
    @SerialName("isLast")
    val isLast: Boolean,
)