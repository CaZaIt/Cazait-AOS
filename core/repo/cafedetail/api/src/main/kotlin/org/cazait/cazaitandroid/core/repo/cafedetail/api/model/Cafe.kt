package org.cazait.cazaitandroid.core.repo.cafedetail.api.model

data class Cafe(
    val name: CafeName,
    val congestion: Congestion,
    val address: CafeAddress,
    val cafeImages: CafeImages,
    val favorite: Favorite,
)
