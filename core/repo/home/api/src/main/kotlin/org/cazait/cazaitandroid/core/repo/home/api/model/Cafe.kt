package org.cazait.cazaitandroid.core.repo.home.api.model

import org.cazait.cazaitandroid.core.model.cafe.CafeAddress
import org.cazait.cazaitandroid.core.model.cafe.CafeId
import org.cazait.cazaitandroid.core.model.cafe.CafeImages
import org.cazait.cazaitandroid.core.model.cafe.CafeName

data class Cafe(
    val id: CafeId,
    val name: CafeName,
    val address: CafeAddress,
    val cafeImages: CafeImages,
    val latitude: Latitude,
    val longitude: Longitude,
)

@JvmInline
value class Cafes(private val values: List<Cafe>) {
    fun asList(): List<Cafe> = values
}
