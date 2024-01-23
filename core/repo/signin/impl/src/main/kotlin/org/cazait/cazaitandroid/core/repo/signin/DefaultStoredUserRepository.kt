package org.cazait.cazaitandroid.core.repo.signin

import kotlinx.coroutines.flow.Flow
import org.cazait.cazaitandroid.core.repo.signin.api.StoredUserRepository
import org.cazait.cazaitandroid.core.repo.signin.api.model.StoredUser
import javax.inject.Inject

internal class DefaultStoredUserRepository @Inject constructor(
    private val preferencesDataSource: StoredUserPreferencesDataSource,
) : StoredUserRepository {
    override fun getUser(): Flow<StoredUser?> = preferencesDataSource.storedUserData

    override suspend fun updateStoredUser(user: StoredUser): StoredUser {
        return preferencesDataSource.updateStoredUser(user)
    }

    override suspend fun deleteStoredUser() {
        preferencesDataSource.deleteStoredUser()
    }
}
