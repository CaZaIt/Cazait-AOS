package org.cazait.cazaitandroid.feature.signin.usecase

import org.cazait.cazaitandroid.core.repo.signin.api.StoredUserRepository
import org.cazait.cazaitandroid.core.repo.signin.api.model.StoredUser
import javax.inject.Inject

internal interface UpdateUserInformationToLocalUseCase {
    suspend operator fun invoke(userInformation: StoredUser): StoredUser
}

internal class UpdateUserInformationToLocalUseCaseImpl @Inject constructor(
    private val repository: StoredUserRepository,
) : UpdateUserInformationToLocalUseCase {
    override suspend fun invoke(userInformation: StoredUser): StoredUser {
        return repository.updateStoredUser(userInformation)
    }
}
