package org.cazait.cazaitandroid.feature.splash

import androidx.compose.foundation.layout.PaddingValues
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable

object SplashNav {
    const val route: String = "splash"
}

fun NavGraphBuilder.splashNavGraph(
    padding: PaddingValues,
    onClickStart: () -> Unit,
) {
    composable(route = SplashNav.route) {
        SplashRoute(
            padding = padding,
            onClickStart = onClickStart,
        )
    }
}
