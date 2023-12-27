package org.cazait.cazaitandroid.core.repo.signin.mapper

import org.cazait.cazaitandroid.core.repo.signin.api.model.AccessToken
import org.cazait.cazaitandroid.core.repo.signin.api.model.AccountName
import org.cazait.cazaitandroid.core.repo.signin.api.model.RefreshToken
import org.cazait.cazaitandroid.core.repo.signin.api.model.UserId
import org.cazait.cazaitandroid.core.repo.signin.api.model.UserInformation
import org.cazait.cazaitandroid.core.repo.signin.network.model.UserInformationResponse
import java.util.UUID

internal fun UserInformationResponse.toData(): UserInformation = UserInformation(
    userId = UserId(UUID.fromString(id)),
    accountName = AccountName(accountName),
    accessToken = AccessToken(accessToken),
    refreshToken = RefreshToken(refreshToken),
)
