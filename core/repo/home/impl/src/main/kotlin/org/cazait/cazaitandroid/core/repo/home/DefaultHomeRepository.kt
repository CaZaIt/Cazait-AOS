package org.cazait.cazaitandroid.core.repo.home

import org.cazait.cazaitandroid.core.repo.home.api.HomeRepository
import org.cazait.cazaitandroid.core.repo.home.api.model.CongestionCafes
import org.cazait.cazaitandroid.core.repo.home.api.model.DistanceLimit
import org.cazait.cazaitandroid.core.repo.home.api.model.Latitude
import org.cazait.cazaitandroid.core.repo.home.api.model.Longitude
import org.cazait.cazaitandroid.core.repo.home.api.model.SortBy
import org.cazait.cazaitandroid.core.repo.home.mapper.toData
import org.cazait.cazaitandroid.core.repo.home.network.HomeApi
import javax.inject.Inject

internal class DefaultHomeRepository @Inject constructor(
    private val homeApi: HomeApi,
) : HomeRepository {
    override suspend fun getAllCongestionCafes(
        latitude: Latitude,
        longitude: Longitude,
        sort: SortBy,
        limit: DistanceLimit,
    ): CongestionCafes {
        return homeApi.getAllCongestionCafes(
            latitude.asString(),
            longitude.asString(),
            sort.name,
            limit.asString(),
        ).data[0].toData()
    }
}
