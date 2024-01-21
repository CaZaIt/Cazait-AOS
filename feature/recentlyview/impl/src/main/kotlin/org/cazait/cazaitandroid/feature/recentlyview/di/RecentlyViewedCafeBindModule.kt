package org.cazait.cazaitandroid.feature.recentlyview.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped
import org.cazait.cazaitandroid.feature.recentlyview.api.RecentlyViewNavController
import org.cazait.cazaitandroid.feature.recentlyview.api.RecentlyViewNavGraph
import org.cazait.cazaitandroid.feature.recentlyview.navigation.RecentlyViewNavControllerImpl
import org.cazait.cazaitandroid.feature.recentlyview.navigation.RecentlyViewNavGraphImpl
import org.cazait.cazaitandroid.feature.recentlyview.usecase.GetAllRecentlyViewedCafeUseCase
import org.cazait.cazaitandroid.feature.recentlyview.usecase.GetAllRecentlyViewedCafeUseCaseImpl

@Module
@InstallIn(ActivityComponent::class)
internal abstract class RecentlyViewedCafeBindModule {
    @Binds
    abstract fun recentlyViewNavControllerImpl(
        dataSource: RecentlyViewNavControllerImpl,
    ): RecentlyViewNavController

    @Binds
    abstract fun recentlyViewNavGraphImpl(
        dataSource: RecentlyViewNavGraphImpl,
    ): RecentlyViewNavGraph
}

@Module
@InstallIn(ViewModelComponent::class)
internal abstract class UseCaseBindModule {
    @Binds
    @ViewModelScoped
    abstract fun bindGetAllRecentlyViewedCafeUseCase(
        datasource: GetAllRecentlyViewedCafeUseCaseImpl,
    ): GetAllRecentlyViewedCafeUseCase
}
