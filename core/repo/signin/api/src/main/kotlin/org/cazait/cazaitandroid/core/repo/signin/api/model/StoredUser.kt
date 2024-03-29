package org.cazait.cazaitandroid.core.repo.signin.api.model

class StoredUser(
    val userId: UserId,
    val accountName: AccountName,
    val accessToken: AccessToken,
    val refreshToken: RefreshToken,
)
