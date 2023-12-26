package org.cazait.cazaitandroid.feature.splash

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable

@Composable
fun SplashRoute(
    padding: PaddingValues,
    onClickStart: () -> Unit,
) {
    SplashScreen(
        padding = padding,
        onClickStart = onClickStart,
    )
}
