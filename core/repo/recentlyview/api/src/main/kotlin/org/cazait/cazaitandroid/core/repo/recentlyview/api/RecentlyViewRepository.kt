package org.cazait.cazaitandroid.core.repo.recentlyview.api

import org.cazait.cazaitandroid.core.repo.recentlyview.api.model.RecentlyViewedCafes

interface RecentlyViewRepository {
    suspend fun getAllRecentlyViewedCafe(): RecentlyViewedCafes
}
