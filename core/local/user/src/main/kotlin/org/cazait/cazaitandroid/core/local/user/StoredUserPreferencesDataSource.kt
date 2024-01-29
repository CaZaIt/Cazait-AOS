package org.cazait.cazaitandroid.core.local.user

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import org.cazait.cazaitandroid.core.model.AccessToken
import org.cazait.cazaitandroid.core.model.AccountName
import org.cazait.cazaitandroid.core.model.RefreshToken
import org.cazait.cazaitandroid.core.model.UserId
import java.util.UUID
import javax.inject.Inject
import javax.inject.Named

internal class StoredUserPreferencesDataSource @Inject constructor(
    @Named(PreferenceKeys.DATA_STORE) private val dataStore: DataStore<Preferences>,
) {
    object PreferenceKeys {
        const val DATA_STORE = "user_data_store"
        val USER_ID = stringPreferencesKey("USER_ID")
        val ACCOUNT_NAME = stringPreferencesKey("ACCOUNT_NAME")
        val ACCESS_TOKEN = stringPreferencesKey("ACCESS_TOKEN")
        val REFRESH_TOKEN = stringPreferencesKey("REFRESH_TOKEN")
    }

    val storedUserData: Flow<StoredUser?> = dataStore.data.map(::createStoredUser)

    suspend fun updateStoredUser(storedUser: StoredUser): StoredUser {
        val preferences = dataStore.edit { preferences ->
            preferences[PreferenceKeys.USER_ID] = storedUser.userId.asString()
            preferences[PreferenceKeys.ACCOUNT_NAME] = storedUser.accountName.asString()
            preferences[PreferenceKeys.ACCESS_TOKEN] = storedUser.accessToken.asString()
            preferences[PreferenceKeys.REFRESH_TOKEN] = storedUser.refreshToken.asString()
        }
        return createStoredUser(preferences) ?: error("업데이트가 비정상적으로 수행되었습니다.")
    }

    suspend fun deleteStoredUser() {
        dataStore.edit { preferences ->
            preferences.remove(PreferenceKeys.USER_ID)
            preferences.remove(PreferenceKeys.ACCOUNT_NAME)
            preferences.remove(PreferenceKeys.ACCESS_TOKEN)
            preferences.remove(PreferenceKeys.REFRESH_TOKEN)
        }
    }

    private fun createStoredUser(preferences: Preferences): StoredUser? {
        val userId = preferences[PreferenceKeys.USER_ID]?.let {
            UserId(UUID.fromString(it))
        }
        val accountName = preferences[PreferenceKeys.ACCOUNT_NAME]?.let {
            AccountName(it)
        }
        val accessToken = preferences[PreferenceKeys.ACCESS_TOKEN]?.let { AccessToken(it) }
        val refreshToken = preferences[PreferenceKeys.REFRESH_TOKEN]?.let { RefreshToken(it) }
        return if (userId == null || accountName == null || accessToken == null || refreshToken == null) {
            null
        } else {
            StoredUser(
                userId,
                accountName,
                accessToken,
                refreshToken,
            )
        }
    }
}