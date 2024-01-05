package org.cazait.cazaitandroid.core.repo.home.network.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class CongestionCafeResponse(
    @SerialName("cafeId")
    val cafeId: String,
    @SerialName("congestionStatus")
    val congestionStatus: String,
    @SerialName("name")
    val name: String,
    @SerialName("address")
    val address: String,
    @SerialName("latitude")
    val latitude: String,
    @SerialName("longitude")
    val longitude: String,
    @SerialName("cafeImages")
    val cafeImages: List<String>,
    @SerialName("distance")
    val distance: Int,
    @SerialName("favoritesStatus")
    val favoritesStatus: String,
)