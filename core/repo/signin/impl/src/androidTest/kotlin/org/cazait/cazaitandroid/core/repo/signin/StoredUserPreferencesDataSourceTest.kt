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
import org.junit.Before
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

    private val testUserId = UserId(UUID.randomUUID())
    private val testAccountName = AccountName("TestUser")
    private val testAccessToken = AccessToken("access-token-12345")
    private val testRefreshToken = RefreshToken("refresh-token-12345")

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

    @Test
    fun 유저_정보를_삭제하고_불러오기하면_null이다() {
        testCoroutineScope.runTest {
            var expectedStoredUser = testDataSource.storedUserData.first()
            Assert.assertNull(expectedStoredUser)

            testDataSource.deleteStoredUser()
            expectedStoredUser = testDataSource.storedUserData.first()
            Assert.assertNull(expectedStoredUser)

            testDataSource.updateStoredUser(
                StoredUser(
                    userId = testUserId,
                    accountName = testAccountName,
                    accessToken = testAccessToken,
                    refreshToken = testRefreshToken
                )
            )
            expectedStoredUser = testDataSource.storedUserData.first()
            Assert.assertEquals(expectedStoredUser?.userId, testUserId)

            testDataSource.deleteStoredUser()
            expectedStoredUser = testDataSource.storedUserData.first()
            Assert.assertNull(expectedStoredUser)
        }
    }
}