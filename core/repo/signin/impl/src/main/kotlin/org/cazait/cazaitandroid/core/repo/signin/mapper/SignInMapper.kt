package org.cazait.cazaitandroid.core.repo.signin.mapper

import org.cazait.cazaitandroid.core.model.AccessToken
import org.cazait.cazaitandroid.core.model.AccountName
import org.cazait.cazaitandroid.core.model.RefreshToken
import org.cazait.cazaitandroid.core.model.UserId
import org.cazait.cazaitandroid.core.repo.signin.api.model.UserInformation
import org.cazait.cazaitandroid.core.repo.signin.network.model.UserInformationResponse
import java.util.UUID

internal fun UserInformationResponse.toData(): UserInformation = UserInformation(
    userId = org.cazait.cazaitandroid.core.model.UserId(UUID.fromString(id)),
    accountName = org.cazait.cazaitandroid.core.model.AccountName(accountName),
    accessToken = AccessToken(accessToken),
    refreshToken = RefreshToken(refreshToken),
)
