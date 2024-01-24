package org.cazait.cazaitandroid.core.local.user

import org.cazait.cazaitandroid.core.model.AccessToken
import org.cazait.cazaitandroid.core.model.AccountName
import org.cazait.cazaitandroid.core.model.RefreshToken
import org.cazait.cazaitandroid.core.model.UserId

data class StoredUser(
    val userId: UserId,
    val accountName: AccountName,
    val accessToken: AccessToken,
    val refreshToken: RefreshToken,
)
