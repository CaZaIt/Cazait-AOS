package org.cazait.cazaitandroid.feature.mypage.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped
import dagger.multibindings.IntoSet
import org.cazait.cazaitandroid.feature.mypage.api.MyPageNavController
import org.cazait.cazaitandroid.feature.mypage.api.MyPageNavGraph
import org.cazait.cazaitandroid.feature.mypage.navigation.MyPageNavControllerImpl
import org.cazait.cazaitandroid.feature.mypage.navigation.MyPageNavGraphImpl
import org.cazait.cazaitandroid.feature.mypage.navigation.MyPageTab
import org.cazait.cazaitandroid.feature.mypage.usecase.SignOutUseCase
import org.cazait.cazaitandroid.feature.mypage.usecase.SignOutUseCaseImpl
import org.cazait.cazaitandroid.feature.nav.CazaitTab

@Module
@InstallIn(ActivityComponent::class)
internal abstract class MyPageBindModule {

    @Binds
    abstract fun myPageNavControllerImpl(
        dataSource: MyPageNavControllerImpl,
    ): MyPageNavController

    @Binds
    abstract fun myPageNavGraphImpl(
        dataSource: MyPageNavGraphImpl,
    ): MyPageNavGraph

    @Binds
    @IntoSet
    abstract fun myPageTab(
        myPageTab: MyPageTab,
    ): CazaitTab
}

@Module
@InstallIn(ViewModelComponent::class)
internal abstract class BindUseCaseModule {
    @Binds
    @ViewModelScoped
    abstract fun bindSignOutUseCase(
        dataSource: SignOutUseCaseImpl,
    ): SignOutUseCase
}
