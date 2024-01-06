package org.cazait.cazaitandroid.feature.home.usecase

import org.cazait.cazaitandroid.core.repo.home.api.HomeRepository
import org.cazait.cazaitandroid.core.repo.home.api.model.CongestionCafes
import org.cazait.cazaitandroid.core.repo.home.api.model.DistanceLimit
import org.cazait.cazaitandroid.core.repo.home.api.model.Latitude
import org.cazait.cazaitandroid.core.repo.home.api.model.Longitude
import org.cazait.cazaitandroid.core.repo.home.api.model.SortBy
import javax.inject.Inject

internal interface GetCongestionCafesUseCase {
    suspend operator fun invoke(): CongestionCafes
}

internal class GetCongestionCafesUseCaseImpl @Inject constructor(
    private val homeRepository: HomeRepository,
) : GetCongestionCafesUseCase {
    override suspend fun invoke(): CongestionCafes {
        return homeRepository.getAllCongestionCafes(
            latitude = Latitude(0.0),
            longitude = Longitude(0.0),
            sort = SortBy.CONGESTION,
            limit = DistanceLimit(0),
        )
    }
}