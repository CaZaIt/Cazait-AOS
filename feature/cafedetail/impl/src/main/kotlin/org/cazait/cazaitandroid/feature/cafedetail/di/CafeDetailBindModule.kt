package org.cazait.cazaitandroid.feature.cafedetail.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import org.cazait.cazaitandroid.feature.cafedetail.api.CafeDetailNavController
import org.cazait.cazaitandroid.feature.cafedetail.api.CafeDetailNavGraph
import org.cazait.cazaitandroid.feature.cafedetail.navigation.CafeDetailNavControllerImpl
import org.cazait.cazaitandroid.feature.cafedetail.navigation.CafeDetailNavGraphImpl

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
