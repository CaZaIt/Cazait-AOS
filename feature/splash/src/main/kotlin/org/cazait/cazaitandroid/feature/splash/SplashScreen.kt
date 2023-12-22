package org.cazait.cazaitandroid.feature.splash

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun SplashScreen(
    uiState: SplashState,
    actions: SplashActions,
    onSplashFinished: () -> Unit,
) {

}

@Composable
@Preview(name = "Splash")
private fun SplashScreenPreview() {
    SplashScreen(
        uiState = SplashState(),
        actions = SplashActions(),
        onSplashFinished = {},
    )
}
