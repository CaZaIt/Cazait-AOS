package org.cazait.cazaitandroid.core.repo.signin

import org.cazait.cazaitandroid.core.repo.signin.api.SignInRepository
import org.cazait.cazaitandroid.core.repo.signin.api.model.AccountName
import org.cazait.cazaitandroid.core.repo.signin.api.model.Password
import org.cazait.cazaitandroid.core.repo.signin.api.model.UserInformation
import org.cazait.cazaitandroid.core.repo.signin.mapper.toData
import org.cazait.cazaitandroid.core.repo.signin.network.SignInApi
import org.cazait.cazaitandroid.core.repo.signin.network.model.SignInRequest
import javax.inject.Inject

internal class DefaultSignInRepository @Inject constructor(
    private val signInApi: SignInApi,
) : SignInRepository {
    override suspend fun postSignIn(
        accountName: AccountName,
        password: Password,
    ): UserInformation = signInApi.postSignIn(
        SignInRequest(accountName.name, password.word),
    ).data.toData()
}
