package org.cazait.cazaitandroid.core.repo.home

import org.cazait.cazaitandroid.core.httphandle.CazaitHttpException
import org.cazait.cazaitandroid.core.local.recentview.RecentlyViewedCafeDao
import org.cazait.cazaitandroid.core.model.AccessToken
import org.cazait.cazaitandroid.core.model.UserId
import org.cazait.cazaitandroid.core.repo.home.api.HomeRepository
import org.cazait.cazaitandroid.core.repo.home.api.model.Cafe
import org.cazait.cazaitandroid.core.repo.home.api.model.CongestionCafes
import org.cazait.cazaitandroid.core.repo.home.api.model.DistanceLimit
import org.cazait.cazaitandroid.core.repo.home.api.model.FavoritedCafes
import org.cazait.cazaitandroid.core.repo.home.api.model.Latitude
import org.cazait.cazaitandroid.core.repo.home.api.model.Longitude
import org.cazait.cazaitandroid.core.repo.home.api.model.SortBy
import org.cazait.cazaitandroid.core.repo.home.mapper.toData
import org.cazait.cazaitandroid.core.repo.home.mapper.toEntity
import org.cazait.cazaitandroid.core.repo.home.network.HomeApi
import org.cazait.cazaitandroid.core.repo.home.network.model.FavoritedCafeResponse
import retrofit2.HttpException
import java.util.Date
import javax.inject.Inject

internal class DefaultHomeRepository @Inject constructor(
    private val homeApi: HomeApi,
    private val recentlyViewedCafeDao: RecentlyViewedCafeDao,
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

    override suspend fun addRecentlyViewedCafeToDB(cafe: Cafe) {
        recentlyViewedCafeDao.addRecentlyViewedCafeWithLimit(
            cafe.toEntity(date = Date()),
        )
    }

    override suspend fun getFavoritedCafes(
        userId: UserId,
        accessToken: AccessToken,
    ): FavoritedCafes = try {
        FavoritedCafes(
            homeApi.getAllFavoritedCafes(
                userId = userId.asString(),
                accessToken = HomeApi.createTokenHeader(accessToken.asString()),
            ).data.map(FavoritedCafeResponse::toData),
        )
    } catch (e: HttpException) {
        throw CazaitHttpException(e.message(), e.code())
    }
}
