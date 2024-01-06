package org.cazait.cazaitandroid.core.repo.cafedetail.di

import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import org.cazait.cazaitandroid.core.repo.cafedetail.DefaultCafeDetailRepository
import org.cazait.cazaitandroid.core.repo.cafedetail.api.CafeDetailRepository
import org.cazait.cazaitandroid.core.repo.cafedetail.network.CafeDetailApi
import retrofit2.Converter.Factory
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
internal object CafeDetailRepoModule {
    @Provides
    @Singleton
    fun provideCafeDetailApi(
        okHttpClient: OkHttpClient,
        converterFactory: Factory,
    ): CafeDetailApi {
        return Retrofit.Builder()
            .baseUrl("https://cazait.shop")
            .addConverterFactory(converterFactory)
            .client(okHttpClient).build()
            .create(CafeDetailApi::class.java)
    }
}

@Module
@InstallIn(SingletonComponent::class)
internal abstract class CafeDetailRepoBindModule {
    @Binds
    abstract fun bindCafeDetailRepository(
        dataSource: DefaultCafeDetailRepository,
    ): CafeDetailRepository
}