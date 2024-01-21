package org.cazait.cazaitandroid.core.repo.recentlyview

import org.cazait.cazaitandroid.core.local.recentview.RecentlyViewedCafeDao
import org.cazait.cazaitandroid.core.local.recentview.model.CafeEntity
import org.cazait.cazaitandroid.core.repo.recentlyview.api.RecentlyViewRepository
import org.cazait.cazaitandroid.core.repo.recentlyview.api.model.RecentlyViewedCafes
import org.cazait.cazaitandroid.core.repo.recentlyview.mapper.toData

class DefaultRecentlyViewRepository(
    private val database: RecentlyViewedCafeDao,
) : RecentlyViewRepository {
    override suspend fun getAllRecentlyViewedCafe(): RecentlyViewedCafes {
        return RecentlyViewedCafes(database.sortByDate().map(CafeEntity::toData))
    }
}
