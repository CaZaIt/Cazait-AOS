package org.cazait.cazaitandroid.core.repo.signin.di

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.preferencesDataStore
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.android.scopes.ViewModelScoped
import dagger.hilt.components.SingletonComponent
import org.cazait.cazaitandroid.core.repo.signin.DefaultStoredUserRepository
import org.cazait.cazaitandroid.core.repo.signin.StoredUserPreferencesDataSource
import org.cazait.cazaitandroid.core.repo.signin.api.StoredUserRepository
import org.cazait.cazaitandroid.core.repo.signin.api.usecase.GetStoredUserInformationUseCase
import org.cazait.cazaitandroid.core.repo.signin.usecase.GetStoredUserInformationUseCaseImpl
import javax.inject.Named
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
internal object StoredUserRepoModule {
    private const val STORED_USER_DATASTORE_NAME = "STORED_USER"
    private val Context.storedUserDataStore by preferencesDataStore(STORED_USER_DATASTORE_NAME)

    @Provides
    @Singleton
    @Named(StoredUserPreferencesDataSource.PreferenceKeys.DATA_STORE)
    fun provideStoredUserDataStore(
        @ApplicationContext context: Context,
    ): DataStore<Preferences> = context.storedUserDataStore
}

@Module
@InstallIn(SingletonComponent::class)
internal abstract class StoredUserRepoBindModule {
    @Binds
    abstract fun bindStoredUserRepository(
        dataSource: DefaultStoredUserRepository,
    ): StoredUserRepository
}

@Module
@InstallIn(ViewModelComponent::class)
internal abstract class StoredUserUseCaseModule {
    @Binds
    @ViewModelScoped
    abstract fun bindGetStoredUserUseCase(
        dataSource: GetStoredUserInformationUseCaseImpl,
    ): GetStoredUserInformationUseCase
}
