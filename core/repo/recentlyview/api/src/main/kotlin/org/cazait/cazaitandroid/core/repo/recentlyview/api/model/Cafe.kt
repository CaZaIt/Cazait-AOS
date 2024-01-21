package org.cazait.cazaitandroid.core.repo.recentlyview.api.model

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
