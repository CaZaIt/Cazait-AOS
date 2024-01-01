package org.cazait.cazaitandroid.feature.splash

internal sealed interface SplashUiState {
    data object Stored : SplashUiState
    data object NotStored : SplashUiState
}