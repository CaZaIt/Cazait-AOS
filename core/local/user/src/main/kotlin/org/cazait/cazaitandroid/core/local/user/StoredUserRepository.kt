package org.cazait.cazaitandroid.core.local.user

import kotlinx.coroutines.flow.Flow

interface StoredUserRepository {
    fun getUser(): Flow<StoredUser?>
    suspend fun updateStoredUser(user: StoredUser): StoredUser
    suspend fun deleteStoredUser()
}
