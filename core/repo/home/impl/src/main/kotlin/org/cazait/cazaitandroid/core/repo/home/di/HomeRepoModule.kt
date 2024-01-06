package org.cazait.cazaitandroid.core.repo.home.di

import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import org.cazait.cazaitandroid.core.repo.home.DefaultHomeRepository
import org.cazait.cazaitandroid.core.repo.home.api.HomeRepository
import org.cazait.cazaitandroid.core.repo.home.network.HomeApi
import retrofit2.Converter
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
internal object HomeRepoModule {
    @Provides
    @Singleton
    fun provideHomeApi(
        okHttpClient: OkHttpClient,
        converterFactory: Converter.Factory,
    ): HomeApi {
        return Retrofit.Builder()
            .baseUrl("https://cazait.shop")
            .addConverterFactory(converterFactory)
            .client(okHttpClient).build()
            .create(HomeApi::class.java)
    }
}

@Module
@InstallIn(SingletonComponent::class)
internal abstract class HomeRepoBindModule {
    @Binds
    abstract fun bindHomeRepository(
        dataSource: DefaultHomeRepository,
    ): HomeRepository
}
