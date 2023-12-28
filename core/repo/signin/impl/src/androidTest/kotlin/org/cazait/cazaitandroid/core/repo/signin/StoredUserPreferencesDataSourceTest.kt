package org.cazait.cazaitandroid.core.repo.signin

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.PreferenceDataStoreFactory
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.preferencesDataStoreFile
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.test.TestScope
import kotlinx.coroutines.test.runTest
import org.cazait.cazaitandroid.core.repo.signin.api.model.AccessToken
import org.cazait.cazaitandroid.core.repo.signin.api.model.AccountName
import org.cazait.cazaitandroid.core.repo.signin.api.model.RefreshToken
import org.cazait.cazaitandroid.core.repo.signin.api.model.StoredUser
import org.cazait.cazaitandroid.core.repo.signin.api.model.UserId
import org.junit.Assert
import org.junit.Test
import org.junit.runner.RunWith
import java.util.UUID

@RunWith(AndroidJUnit4::class)
class StoredUserPreferencesDataSourceTest {
    private val testContext: Context = ApplicationProvider.getApplicationContext()
    private val testCoroutineScope = TestScope()
    private val testDataStore: DataStore<Preferences> =
        PreferenceDataStoreFactory.create(
            scope = testCoroutineScope
        ) { testContext.preferencesDataStoreFile("test_datastore") }
    private val testDataSource = StoredUserPreferencesDataSource(testDataStore)

    @Test
    fun 유저_정보가_저장되지_않았다면_null을_반환한다() {
        testCoroutineScope.runTest {
            val unStoredUser = testDataSource.storedUserData.first()

            Assert.assertEquals(
                null,
                unStoredUser,
            )
        }
    }

    @Test
    fun 저장된_유저_정보는_불러오는_유저_정보와_같다() {
        testCoroutineScope.runTest {
            val testUserId = UserId(UUID.randomUUID())
            val testAccountName = AccountName("TestUser")
            val testAccessToken = AccessToken("access-token-12345")
            val testRefreshToken = RefreshToken("refresh-token-12345")

            testDataSource.updateStoredUser(
                StoredUser(
                    userId = testUserId,
                    accountName = testAccountName,
                    accessToken = testAccessToken,
                    refreshToken = testRefreshToken
                )
            )
            val expectedStoredUser = testDataSource.storedUserData.first()

            Assert.assertNotNull(expectedStoredUser)
            Assert.assertEquals(expectedStoredUser?.userId, testUserId)
            Assert.assertEquals(expectedStoredUser?.accountName, testAccountName)
            Assert.assertEquals(expectedStoredUser?.accessToken, testAccessToken)
            Assert.assertEquals(expectedStoredUser?.refreshToken, testRefreshToken)
        }
    }
}