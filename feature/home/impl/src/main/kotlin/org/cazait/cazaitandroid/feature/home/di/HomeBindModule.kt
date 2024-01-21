package org.cazait.cazaitandroid.feature.home.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped
import dagger.multibindings.IntoSet
import org.cazait.cazaitandroid.feature.home.api.HomeNavController
import org.cazait.cazaitandroid.feature.home.api.HomeNavGraph
import org.cazait.cazaitandroid.feature.home.navigation.HomeNavControllerImpl
import org.cazait.cazaitandroid.feature.home.navigation.HomeNavGraphImpl
import org.cazait.cazaitandroid.feature.home.navigation.HomeTab
import org.cazait.cazaitandroid.feature.home.usecase.GetCongestionCafesUseCase
import org.cazait.cazaitandroid.feature.home.usecase.GetCongestionCafesUseCaseImpl
import org.cazait.cazaitandroid.feature.home.usecase.StoreViewedCafeUseCase
import org.cazait.cazaitandroid.feature.home.usecase.StoreViewedCafeUseCaseImpl
import org.cazait.cazaitandroid.feature.nav.CazaitTab

@Module
@InstallIn(ActivityComponent::class)
internal abstract class HomeBindModule {
    @Binds
    abstract fun homeNavControllerImpl(
        dataSource: HomeNavControllerImpl,
    ): HomeNavController

    @Binds
    abstract fun homeNavGraphImpl(
        dataSource: HomeNavGraphImpl,
    ): HomeNavGraph

    @Binds
    @IntoSet
    abstract fun homeTab(
        homeTab: HomeTab,
    ): CazaitTab
}

@Module
@InstallIn(ViewModelComponent::class)
internal abstract class UseCaseBindModule {
    @Binds
    @ViewModelScoped
    abstract fun bindGetCongestionCafesUseCase(
        datasource: GetCongestionCafesUseCaseImpl,
    ): GetCongestionCafesUseCase

    @Binds
    @ViewModelScoped
    abstract fun bindStoreViewedCafeUseCase(
        dataSource: StoreViewedCafeUseCaseImpl,
    ): StoreViewedCafeUseCase
}
