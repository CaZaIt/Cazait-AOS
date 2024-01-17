package org.cazait.cazaitandroid.core.repo.home.api

import org.cazait.cazaitandroid.core.repo.home.api.model.CongestionCafes
import org.cazait.cazaitandroid.core.repo.home.api.model.DistanceLimit
import org.cazait.cazaitandroid.core.repo.home.api.model.Latitude
import org.cazait.cazaitandroid.core.repo.home.api.model.Longitude
import org.cazait.cazaitandroid.core.repo.home.api.model.SortBy

interface HomeRepository {
    suspend fun getAllCongestionCafes(
        latitude: Latitude,
        longitude: Longitude,
        sort: SortBy,
        limit: DistanceLimit,
    ): CongestionCafes
}
