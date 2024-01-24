package org.cazait.cazaitandroid.core.local.user.usecase

import org.cazait.cazaitandroid.core.local.user.StoredUser
import org.cazait.cazaitandroid.core.local.user.StoredUserRepository
import javax.inject.Inject

internal class UpdateStoredUserInformationUseCaseImpl @Inject constructor(
    private val repository: StoredUserRepository,
) : UpdateStoredUserInformationUseCase {
    override suspend fun invoke(user: StoredUser): StoredUser {
        return repository.updateStoredUser(user = user)
    }
}
