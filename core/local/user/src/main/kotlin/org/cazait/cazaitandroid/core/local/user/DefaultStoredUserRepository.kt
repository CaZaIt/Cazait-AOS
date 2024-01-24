package org.cazait.cazaitandroid.core.local.user

import kotlinx.coroutines.flow.Flow
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
