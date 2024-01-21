package org.cazait.cazaitandroid.feature.viewmore.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.multibindings.IntoSet
import org.cazait.cazaitandroid.feature.nav.CazaitTab
import org.cazait.cazaitandroid.feature.viewmore.api.ViewMoreNavController
import org.cazait.cazaitandroid.feature.viewmore.api.ViewMoreNavGraph
import org.cazait.cazaitandroid.feature.viewmore.navigation.ViewMoreNavControllerImpl
import org.cazait.cazaitandroid.feature.viewmore.navigation.ViewMoreNavGraphImpl
import org.cazait.cazaitandroid.feature.viewmore.navigation.ViewMoreTab

@Module
@InstallIn(ActivityComponent::class)
internal abstract class ViewMoreBindModule {
    @Binds
    abstract fun viewMoreNavControllerImpl(
        dataSource: ViewMoreNavControllerImpl,
    ): ViewMoreNavController

    @Binds
    abstract fun viewMoreNavGraphImpl(
        dataSource: ViewMoreNavGraphImpl,
    ): ViewMoreNavGraph

    @Binds
    @IntoSet
    abstract fun viewMoreTab(
        viewMoreTab: ViewMoreTab,
    ): CazaitTab
}
