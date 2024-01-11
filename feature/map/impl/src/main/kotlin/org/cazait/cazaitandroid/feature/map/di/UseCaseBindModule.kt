package org.cazait.cazaitandroid.feature.map.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped
import org.cazait.cazaitandroid.feature.map.usecase.GetCongestionCafesUseCase
import org.cazait.cazaitandroid.feature.map.usecase.GetCongestionCafesUseCaseImpl

@Module
@InstallIn(ViewModelComponent::class)
internal abstract class UseCaseBindModule {
    @Binds
    @ViewModelScoped
    abstract fun bindGetCongestionCafesUseCase(
        datasource: GetCongestionCafesUseCaseImpl,
    ): GetCongestionCafesUseCase
}