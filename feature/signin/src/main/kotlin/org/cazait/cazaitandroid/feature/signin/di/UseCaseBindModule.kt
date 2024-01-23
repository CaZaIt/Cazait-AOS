package org.cazait.cazaitandroid.feature.signin.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped
import org.cazait.cazaitandroid.feature.signin.usecase.PostSignInUseCase
import org.cazait.cazaitandroid.feature.signin.usecase.PostSignInUseCaseImpl

@Module
@InstallIn(ViewModelComponent::class)
internal abstract class UseCaseBindModule {
    @Binds
    @ViewModelScoped
    abstract fun postSignInUseCase(
        dataSource: PostSignInUseCaseImpl,
    ): PostSignInUseCase

//    @Binds
//    @ViewModelScoped
//    abstract fun updateUserInformationToLocalUseCase(
//        dataSource: UpdateUserInformationToLocalUseCaseImpl,
//    ): UpdateUserInformationToLocalUseCase
}
