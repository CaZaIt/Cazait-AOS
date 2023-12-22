package org.cazait.cazaitandroid.feature.splash

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember

@Composable
fun SplashRoute(
    padding: PaddingValues,
    onSplashFinished: () -> Unit,
    coordinator: SplashCoordinator = rememberSplashCoordinator(),
) {
    val uiState by coordinator.screenStateFlow.collectAsState()
    val actions = rememberSplashActions(coordinator)
    SplashScreen(
        uiState = uiState,
        actions = actions,
        onSplashFinished = onSplashFinished,
    )
}

@Composable
fun rememberSplashActions(coordinator: SplashCoordinator): SplashActions {
    return remember(coordinator) {
        SplashActions(
        )
    }
}
