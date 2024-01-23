package org.cazait.cazaitandroid.feature.home.usecase

import org.cazait.cazaitandroid.core.model.AccessToken
import org.cazait.cazaitandroid.core.model.UserId
import org.cazait.cazaitandroid.core.repo.home.api.HomeRepository
import org.cazait.cazaitandroid.core.repo.home.api.model.FavoritedCafes
import javax.inject.Inject

internal interface GetFavoritedCafesUseCase {
    suspend operator fun invoke(userId: UserId, accessToken: AccessToken): FavoritedCafes
}

internal class GetFavoritedCafesUseCaseImpl @Inject constructor(
    private val homeRepository: HomeRepository,
) : GetFavoritedCafesUseCase {
    override suspend fun invoke(userId: UserId, accessToken: AccessToken): FavoritedCafes {
        return homeRepository.getFavoritedCafes(
            userId = userId,
            accessToken = accessToken,
        )
    }
}
