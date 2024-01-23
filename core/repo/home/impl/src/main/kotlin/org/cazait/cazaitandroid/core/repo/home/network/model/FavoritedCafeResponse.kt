package org.cazait.cazaitandroid.core.repo.home.network.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class FavoritedCafeResponse(
    @SerialName("favoritesId")
    val favoritesId: Int,
    @SerialName("cafeId")
    val cafeId: String,
    @SerialName("name")
    val name: String,
    @SerialName("address")
    val address: String,
    @SerialName("latitude")
    val latitude: String,
    @SerialName("longitude")
    val longitude: String,
    @SerialName("congestion")
    val congestion: String,
    @SerialName("imageUrl")
    val imageUrl: String,
)
