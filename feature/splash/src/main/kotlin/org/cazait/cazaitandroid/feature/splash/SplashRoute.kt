package org.cazait.cazaitandroid.feature.splash

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle

@Composable
internal fun SplashRoute(
    onClickStart: () -> Unit,
    onUserInformationStored: () -> Unit,
    viewModel: SplashViewModel = hiltViewModel(),
) {
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()

    when (uiState) {
        SplashUiState.Stored -> onUserInformationStored()
        SplashUiState.NotStored -> SplashScreen(onClickStart = onClickStart)
    }
}
