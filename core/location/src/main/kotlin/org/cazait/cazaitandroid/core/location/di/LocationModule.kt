package org.cazait.cazaitandroid.core.location.di

import android.content.Context
import com.google.android.gms.location.LocationServices
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.android.scopes.ViewModelScoped
import dagger.hilt.components.SingletonComponent
import org.cazait.cazaitandroid.core.location.LocationService
import org.cazait.cazaitandroid.core.location.LocationServiceImpl
import org.cazait.cazaitandroid.core.location.usecase.GetLocationUseCase
import org.cazait.cazaitandroid.core.location.usecase.GetLocationUseCaseImpl
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
internal object LocationModule {
    @Singleton
    @Provides
    fun provideLocationClient(
        @ApplicationContext context: Context,
    ): LocationService = LocationServiceImpl(
        context = context,
        locationClient = LocationServices.getFusedLocationProviderClient(context)
    )
}

@Module
@InstallIn(ViewModelComponent::class)
internal abstract class UseCaseBindModule {
    @Binds
    @ViewModelScoped
    abstract fun bindGetLocationUseCase(
        dataSource: GetLocationUseCaseImpl,
    ): GetLocationUseCase
}