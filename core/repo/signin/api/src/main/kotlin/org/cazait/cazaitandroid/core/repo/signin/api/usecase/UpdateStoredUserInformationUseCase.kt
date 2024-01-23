package org.cazait.cazaitandroid.core.repo.signin.api.usecase

import org.cazait.cazaitandroid.core.repo.signin.api.model.StoredUser

interface UpdateStoredUserInformationUseCase {
    suspend operator fun invoke(user: StoredUser): StoredUser
}
