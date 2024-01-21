package org.cazait.cazaitandroid.core.repo.signin.api.usecase

import kotlinx.coroutines.flow.Flow
import org.cazait.cazaitandroid.core.repo.signin.api.model.StoredUser

interface GetStoredUserInformationUseCase {
    suspend operator fun invoke(): Flow<StoredUser?>
}
