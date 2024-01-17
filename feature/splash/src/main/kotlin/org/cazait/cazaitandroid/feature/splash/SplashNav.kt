package org.cazait.cazaitandroid.feature.splash

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable

object SplashNav {
    const val route: String = "splash"
}

fun NavGraphBuilder.splashNavGraph(
    onClickStart: () -> Unit,
    onUserInformationStored: () -> Unit,
) {
    composable(route = SplashNav.route) {
        SplashRoute(
            onClickStart = onClickStart,
            onUserInformationStored = onUserInformationStored,
        )
    }
}
