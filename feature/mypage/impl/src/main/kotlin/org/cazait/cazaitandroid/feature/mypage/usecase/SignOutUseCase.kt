package org.cazait.cazaitandroid.feature.mypage.usecase

import org.cazait.cazaitandroid.core.local.user.StoredUserRepository
import javax.inject.Inject

interface SignOutUseCase {
    suspend operator fun invoke()
}

internal class SignOutUseCaseImpl @Inject constructor(
    private val repository: StoredUserRepository,
) : SignOutUseCase {
    override suspend fun invoke() {
        repository.deleteStoredUser()
    }
}
