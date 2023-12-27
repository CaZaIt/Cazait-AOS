package org.cazait.cazaitandroid.feature.splash

import androidx.compose.runtime.Composable

@Composable
fun SplashRoute(
    onClickStart: () -> Unit,
) {
    SplashScreen(
        onClickStart = onClickStart,
    )
}
