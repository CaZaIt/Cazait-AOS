package org.cazait.cazaitandroid.core.repo.signin.usecase

import org.cazait.cazaitandroid.core.repo.signin.api.StoredUserRepository
import org.cazait.cazaitandroid.core.repo.signin.api.model.StoredUser
import org.cazait.cazaitandroid.core.repo.signin.api.usecase.UpdateStoredUserInformationUseCase
import javax.inject.Inject

internal class UpdateStoredUserInformationUseCaseImpl @Inject constructor(
    private val repository: StoredUserRepository,
) : UpdateStoredUserInformationUseCase {
    override suspend fun invoke(user: StoredUser): StoredUser {
        return repository.updateStoredUser(user = user)
    }
}
