package org.cazait.cazaitandroid.feature.splash.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped
import org.cazait.cazaitandroid.feature.splash.usecase.GetStoredUserInformationUseCase
import org.cazait.cazaitandroid.feature.splash.usecase.GetStoredUserInformationUseCaseImpl

@Module
@InstallIn(ViewModelComponent::class)
internal abstract class UseCaseBindModule {
    @Binds
    @ViewModelScoped
    abstract fun getStoredUserInformationUseCase(
        dataSource: GetStoredUserInformationUseCaseImpl,
    ): GetStoredUserInformationUseCase
}
