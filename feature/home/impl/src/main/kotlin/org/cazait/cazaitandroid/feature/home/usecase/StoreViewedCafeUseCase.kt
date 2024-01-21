package org.cazait.cazaitandroid.feature.home.usecase

import org.cazait.cazaitandroid.core.repo.home.api.HomeRepository
import org.cazait.cazaitandroid.core.repo.home.api.model.Cafe
import javax.inject.Inject

internal interface StoreViewedCafeUseCase {
    suspend operator fun invoke(cafe: Cafe)
}

internal class StoreViewedCafeUseCaseImpl @Inject constructor(
    private val repository: HomeRepository,
) : StoreViewedCafeUseCase {
    override suspend fun invoke(cafe: Cafe) {
        return repository.addRecentlyViewedCafeToDB(cafe)
    }
}
