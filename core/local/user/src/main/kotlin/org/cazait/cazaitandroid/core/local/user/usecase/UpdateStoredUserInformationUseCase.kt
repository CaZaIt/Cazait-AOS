package org.cazait.cazaitandroid.core.local.user.usecase

import org.cazait.cazaitandroid.core.local.user.StoredUser

interface UpdateStoredUserInformationUseCase {
    suspend operator fun invoke(user: StoredUser): StoredUser
}
