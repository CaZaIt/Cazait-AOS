package org.cazait.cazaitandroid.core.repo.recentlyview.api.model

data class RecentlyViewedCafe(
    val id: CafeId,
    val name: CafeName,
    val address: CafeAddress,
    val cafeImages: CafeImages,
    val latitude: Latitude,
    val longitude: Longitude,
)
