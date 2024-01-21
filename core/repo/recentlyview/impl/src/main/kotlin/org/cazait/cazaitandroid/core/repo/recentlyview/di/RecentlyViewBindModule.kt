package org.cazait.cazaitandroid.core.repo.recentlyview.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import org.cazait.cazaitandroid.core.repo.recentlyview.DefaultRecentlyViewRepository
import org.cazait.cazaitandroid.core.repo.recentlyview.api.RecentlyViewRepository

@Module
@InstallIn(SingletonComponent::class)
internal abstract class RecentlyViewBindModule {
    @Binds
    abstract fun bindRecentlyViewRepository(
        dataSource: DefaultRecentlyViewRepository,
    ): RecentlyViewRepository
}
