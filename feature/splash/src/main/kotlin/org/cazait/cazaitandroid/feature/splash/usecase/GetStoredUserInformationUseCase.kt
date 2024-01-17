package org.cazait.cazaitandroid.feature.splash.usecase

import kotlinx.coroutines.flow.Flow
import org.cazait.cazaitandroid.core.repo.signin.api.StoredUserRepository
import org.cazait.cazaitandroid.core.repo.signin.api.model.StoredUser
import javax.inject.Inject

internal interface GetStoredUserInformationUseCase {
    suspend operator fun invoke(): Flow<StoredUser?>
}

internal class GetStoredUserInformationUseCaseImpl @Inject constructor(
    private val repository: StoredUserRepository,
) : GetStoredUserInformationUseCase {
    override suspend fun invoke(): Flow<StoredUser?> = repository.getUser()
}
