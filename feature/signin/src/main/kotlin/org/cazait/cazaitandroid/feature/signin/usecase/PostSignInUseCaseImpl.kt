package org.cazait.cazaitandroid.feature.signin.usecase

import org.cazait.cazaitandroid.core.repo.signin.api.SignInRepository
import org.cazait.cazaitandroid.core.repo.signin.api.model.AccountName
import org.cazait.cazaitandroid.core.repo.signin.api.model.Password
import org.cazait.cazaitandroid.core.repo.signin.api.model.UserInformation
import javax.inject.Inject

internal interface PostSignInUseCase {
    suspend operator fun invoke(accountName: AccountName, password: Password): UserInformation
}

internal class PostSignInUseCaseImpl @Inject constructor(
    private val repository: SignInRepository,
) : PostSignInUseCase {
    override suspend fun invoke(accountName: AccountName, password: Password): UserInformation {
        return repository.postSignIn(
            accountName = accountName,
            password = password,
        )
    }
}
