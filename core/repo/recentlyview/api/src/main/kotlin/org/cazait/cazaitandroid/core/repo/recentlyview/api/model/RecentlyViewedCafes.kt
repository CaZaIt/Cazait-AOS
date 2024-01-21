package org.cazait.cazaitandroid.core.repo.recentlyview.api.model

@JvmInline
value class RecentlyViewedCafes(
    private val cafes: List<RecentlyViewedCafe>,
) {
    fun asList(): List<RecentlyViewedCafe> = cafes
}
