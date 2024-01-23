package org.cazait.cazaitandroid.core.repo.signin.api.model

import org.cazait.cazaitandroid.core.model.AccessToken
import org.cazait.cazaitandroid.core.model.AccountName
import org.cazait.cazaitandroid.core.model.RefreshToken
import org.cazait.cazaitandroid.core.model.UserId

class StoredUser(
    val userId: UserId,
    val accountName: AccountName,
    val accessToken: AccessToken,
    val refreshToken: RefreshToken,
)
