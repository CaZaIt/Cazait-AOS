package org.cazait.cazaitandroid.core.repo.signin

import org.cazait.cazaitandroid.core.httphandle.CazaitHttpException
import org.cazait.cazaitandroid.core.repo.signin.api.SignInRepository
import org.cazait.cazaitandroid.core.repo.signin.api.model.AccountName
import org.cazait.cazaitandroid.core.repo.signin.api.model.Password
import org.cazait.cazaitandroid.core.repo.signin.api.model.UserInformation
import org.cazait.cazaitandroid.core.repo.signin.mapper.toData
import org.cazait.cazaitandroid.core.repo.signin.network.SignInApi
import org.cazait.cazaitandroid.core.repo.signin.network.model.SignInRequest
import retrofit2.HttpException
import javax.inject.Inject

internal class DefaultSignInRepository @Inject constructor(
    private val signInApi: SignInApi,
) : SignInRepository {
    override suspend fun postSignIn(
        accountName: AccountName,
        password: Password,
    ): UserInformation = try {
        signInApi.postSignIn(
            SignInRequest(accountName.name, password.word),
        ).data.toData()
    } catch (e: HttpException) {
        throw CazaitHttpException(e.message(), e.code())
    }
}
