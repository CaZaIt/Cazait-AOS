package org.cazait.cazaitandroid.core.repo.cafedetail.network.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
internal data class CafeMenuResponse(
    @SerialName("menuId")
    val menuId: Int,
    @SerialName("name")
    val name: String,
    @SerialName("description")
    val description: String,
    @SerialName("price")
    val price: Int,
    @SerialName("imageUrl")
    val imageUrl: String,
)