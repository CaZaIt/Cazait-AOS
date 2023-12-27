package org.cazait.cazaitandroid.core.repo.signin.api

import org.cazait.cazaitandroid.core.repo.signin.api.model.AccountName
import org.cazait.cazaitandroid.core.repo.signin.api.model.Password
import org.cazait.cazaitandroid.core.repo.signin.api.model.UserInformation

interface SignInRepository {
    suspend fun postSignIn(accountName: AccountName, password: Password): UserInformation
}
