package org.cazait.cazaitandroid.feature.map.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped
import dagger.multibindings.IntoSet
import org.cazait.cazaitandroid.feature.map.api.MapNavController
import org.cazait.cazaitandroid.feature.map.api.MapNavGraph
import org.cazait.cazaitandroid.feature.map.navigation.MapNavControllerImpl
import org.cazait.cazaitandroid.feature.map.navigation.MapNavGraphImpl
import org.cazait.cazaitandroid.feature.map.navigation.MapTab
import org.cazait.cazaitandroid.feature.map.usecase.GetCongestionCafesUseCase
import org.cazait.cazaitandroid.feature.map.usecase.GetCongestionCafesUseCaseImpl
import org.cazait.cazaitandroid.feature.nav.CazaitTab

@Module
@InstallIn(ActivityComponent::class)
internal abstract class MapBindModule {
    @Binds
    abstract fun mapNavControllerImpl(
        dataSource: MapNavControllerImpl,
    ): MapNavController

    @Binds
    abstract fun mapNavGraphImpl(
        dataSource: MapNavGraphImpl,
    ): MapNavGraph

    @Binds
    @IntoSet
    abstract fun mapTab(
        mapTab: MapTab,
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
}
