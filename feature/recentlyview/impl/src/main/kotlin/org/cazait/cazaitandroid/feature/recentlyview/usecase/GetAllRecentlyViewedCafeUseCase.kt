package org.cazait.cazaitandroid.feature.recentlyview.usecase

import org.cazait.cazaitandroid.core.repo.recentlyview.api.RecentlyViewRepository
import org.cazait.cazaitandroid.core.repo.recentlyview.api.model.RecentlyViewedCafes

internal interface GetAllRecentlyViewedCafeUseCase {
    suspend operator fun invoke(): RecentlyViewedCafes
}

internal class GetAllRecentlyViewedCafeUseCaseImpl(
    private val repository: RecentlyViewRepository
) : GetAllRecentlyViewedCafeUseCase {
    override suspend fun invoke(): RecentlyViewedCafes {
        return repository.getAllRecentlyViewedCafe()
    }
}
