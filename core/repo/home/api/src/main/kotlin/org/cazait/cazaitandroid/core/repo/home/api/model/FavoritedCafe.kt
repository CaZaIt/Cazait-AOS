package org.cazait.cazaitandroid.core.repo.home.api.model

data class FavoritedCafe(
    val favoritesId: FavoritesId,
    val cafeId: CafeId,
    val name: CafeName,
    val address: CafeAddress,
    val latitude: Latitude,
    val longitude: Longitude,
    val congestion: Congestion,
    val image: CafeImage,
)

@JvmInline
value class FavoritedCafes(private val cafes: List<FavoritedCafe>) {
    fun asList(): List<FavoritedCafe> = cafes
}
