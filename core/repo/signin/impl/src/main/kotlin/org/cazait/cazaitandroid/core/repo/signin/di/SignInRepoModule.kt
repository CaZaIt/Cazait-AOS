package org.cazait.cazaitandroid.core.repo.signin.di

import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import org.cazait.cazaitandroid.core.repo.signin.DefaultSignInRepository
import org.cazait.cazaitandroid.core.repo.signin.api.SignInRepository
import org.cazait.cazaitandroid.core.repo.signin.network.SignInApi
import retrofit2.Converter
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
internal object SignInRepoModule {
    @Provides
    @Singleton
    fun provideSignInApi(
        okHttpClient: OkHttpClient,
        converterFactory: Converter.Factory,
    ): SignInApi {
        return Retrofit.Builder()
            .baseUrl("https://cazait.shop")
            .addConverterFactory(converterFactory)
            .client(okHttpClient).build()
            .create(SignInApi::class.java)
    }
}

@Module
@InstallIn(SingletonComponent::class)
internal abstract class SignInRepoBindModule {
    @Binds
    abstract fun bindSignInRepository(
        dataSource: DefaultSignInRepository,
    ): SignInRepository
}
