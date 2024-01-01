package org.cazait.cazaitandroid.core.repo.signin.api

import kotlinx.coroutines.flow.Flow
import org.cazait.cazaitandroid.core.repo.signin.api.model.StoredUser

interface StoredUserRepository {
    fun getUser(): Flow<StoredUser?>
    suspend fun updateStoredUser(user: StoredUser)
    suspend fun deleteStoredUser()
}
