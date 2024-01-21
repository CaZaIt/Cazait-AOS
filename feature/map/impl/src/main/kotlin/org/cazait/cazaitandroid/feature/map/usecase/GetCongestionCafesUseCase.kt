package org.cazait.cazaitandroid.feature.map.usecase

import org.cazait.cazaitandroid.core.repo.home.api.HomeRepository
import org.cazait.cazaitandroid.core.repo.home.api.model.CongestionCafes
import org.cazait.cazaitandroid.core.repo.home.api.model.DistanceLimit
import org.cazait.cazaitandroid.core.repo.home.api.model.Latitude
import org.cazait.cazaitandroid.core.repo.home.api.model.Longitude
import org.cazait.cazaitandroid.core.repo.home.api.model.SortBy
import javax.inject.Inject

internal interface GetCongestionCafesUseCase {
    suspend operator fun invoke(
        latitude: Latitude,
        longitude: Longitude,
        sortBy: SortBy,
        limit: DistanceLimit,
    ): CongestionCafes
}

internal class GetCongestionCafesUseCaseImpl @Inject constructor(
    private val homeRepository: HomeRepository,
) : GetCongestionCafesUseCase {
    override suspend fun invoke(
        latitude: Latitude,
        longitude: Longitude,
        sortBy: SortBy,
        limit: DistanceLimit,
    ): CongestionCafes {
        return homeRepository.getAllCongestionCafes(
            latitude = latitude,
            longitude = longitude,
            sort = sortBy,
            limit = limit,
        )
    }
}
