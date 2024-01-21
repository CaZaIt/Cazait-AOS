package org.cazait.cazaitandroid.core.repo.signin.usecase

import kotlinx.coroutines.flow.Flow
import org.cazait.cazaitandroid.core.repo.signin.api.StoredUserRepository
import org.cazait.cazaitandroid.core.repo.signin.api.model.StoredUser
import org.cazait.cazaitandroid.core.repo.signin.api.usecase.GetStoredUserInformationUseCase
import javax.inject.Inject

internal class GetStoredUserInformationUseCaseImpl @Inject constructor(
    private val repository: StoredUserRepository,
) : GetStoredUserInformationUseCase {
    override suspend fun invoke(): Flow<StoredUser?> = repository.getUser()
}