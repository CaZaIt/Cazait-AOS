package org.cazait.cazaitandroid.feature.cafedetail.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped
import org.cazait.cazaitandroid.feature.cafedetail.api.CafeDetailNavController
import org.cazait.cazaitandroid.feature.cafedetail.api.CafeDetailNavGraph
import org.cazait.cazaitandroid.feature.cafedetail.navigation.CafeDetailNavControllerImpl
import org.cazait.cazaitandroid.feature.cafedetail.navigation.CafeDetailNavGraphImpl
import org.cazait.cazaitandroid.feature.cafedetail.usecase.GetCafeMenusUseCase
import org.cazait.cazaitandroid.feature.cafedetail.usecase.GetCafeMenusUseCaseImpl
import org.cazait.cazaitandroid.feature.cafedetail.usecase.GetCafeReviewsUseCase
import org.cazait.cazaitandroid.feature.cafedetail.usecase.GetCafeReviewsUseCaseImpl

@Module
@InstallIn(ActivityComponent::class)
internal abstract class CafeDetailBindModule {
    @Binds
    abstract fun cafeDetailNavControllerImpl(
        dataSource: CafeDetailNavControllerImpl,
    ): CafeDetailNavController

    @Binds
    abstract fun cafeDetailNavGraphImpl(
        dataSource: CafeDetailNavGraphImpl,
    ): CafeDetailNavGraph
}

@Module
@InstallIn(ViewModelComponent::class)
internal abstract class UseCaseBindModule {
    @Binds
    @ViewModelScoped
    abstract fun bindGetCafeMenusUseCase(
        dataSource: GetCafeMenusUseCaseImpl,
    ): GetCafeMenusUseCase

    @Binds
    @ViewModelScoped
    abstract fun bindGetCafeReviewsUseCase(
        dataSource: GetCafeReviewsUseCaseImpl,
    ): GetCafeReviewsUseCase
}
