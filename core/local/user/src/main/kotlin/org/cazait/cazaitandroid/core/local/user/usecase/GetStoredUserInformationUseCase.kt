package org.cazait.cazaitandroid.core.local.user.usecase

import kotlinx.coroutines.flow.Flow
import org.cazait.cazaitandroid.core.local.user.StoredUser

interface GetStoredUserInformationUseCase {
    suspend operator fun invoke(): Flow<StoredUser?>
}
