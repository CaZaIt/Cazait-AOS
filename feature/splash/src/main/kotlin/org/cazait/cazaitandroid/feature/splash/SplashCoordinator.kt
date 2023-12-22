package org.cazait.cazaitandroid.feature.splash

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.hilt.navigation.compose.hiltViewModel

class SplashCoordinator(
    val viewModel: SplashViewModel,
) {
    val screenStateFlow = viewModel.stateFlow

    fun doStuff() {
        // TODO Handle UI Action
    }
}

@Composable
fun rememberSplashCoordinator(
    viewModel: SplashViewModel = hiltViewModel(),
): SplashCoordinator {
    return remember(viewModel) {
        SplashCoordinator(
            viewModel = viewModel,
        )
    }
}
