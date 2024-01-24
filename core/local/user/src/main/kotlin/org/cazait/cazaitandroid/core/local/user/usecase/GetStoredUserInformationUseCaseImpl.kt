package org.cazait.cazaitandroid.core.local.user.usecase

import kotlinx.coroutines.flow.Flow
import org.cazait.cazaitandroid.core.local.user.StoredUser
import org.cazait.cazaitandroid.core.local.user.StoredUserRepository
import javax.inject.Inject

internal class GetStoredUserInformationUseCaseImpl @Inject constructor(
    private val repository: StoredUserRepository,
) : GetStoredUserInformationUseCase {
    override suspend fun invoke(): Flow<StoredUser?> = repository.getUser()
}
