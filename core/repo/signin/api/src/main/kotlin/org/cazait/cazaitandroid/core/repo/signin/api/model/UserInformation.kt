package org.cazait.cazaitandroid.core.repo.signin.api.model

data class UserInformation(
    val userId: UserId,
    val accountName: AccountName,
    val accessToken: AccessToken,
    val refreshToken: RefreshToken,
)
