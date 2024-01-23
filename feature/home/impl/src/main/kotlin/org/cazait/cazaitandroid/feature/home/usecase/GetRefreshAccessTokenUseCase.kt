package org.cazait.cazaitandroid.feature.home.usecase

import org.cazait.cazaitandroid.core.model.AccessToken
import org.cazait.cazaitandroid.core.model.RefreshToken
import org.cazait.cazaitandroid.core.repo.signin.api.SignInRepository
import org.cazait.cazaitandroid.core.repo.signin.api.model.UserInformation
import javax.inject.Inject

internal interface GetRefreshAccessTokenUseCase {
    suspend operator fun invoke(
        accessToken: AccessToken,
        refreshToken: RefreshToken,
    ): UserInformation
}

internal class GetRefreshAccessTokenUseCaseImpl @Inject constructor(
    private val signInRepository: SignInRepository,
) : GetRefreshAccessTokenUseCase {
    override suspend fun invoke(
        accessToken: AccessToken,
        refreshToken: RefreshToken,
    ): UserInformation {
        return signInRepository.refreshAccessToken(
            accessToken,
            refreshToken,
        )
    }
}
