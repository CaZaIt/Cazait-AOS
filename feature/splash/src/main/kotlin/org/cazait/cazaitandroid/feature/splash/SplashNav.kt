package org.cazait.cazaitandroid.feature.splash

import androidx.compose.foundation.layout.PaddingValues
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable

object SplashNav {
    const val route: String = "splash"
}

fun NavController.navigateSplash(navOptions: NavOptions) {
    navigate(SplashNav.route, navOptions)
}

fun NavGraphBuilder.splashNavGraph(
    padding: PaddingValues,
    onSplashFinished: () -> Unit,
    onShowErrorSnackbar: (throwable: Throwable?) -> Unit,
) {
    composable(route = SplashNav.route) {
        SplashRoute(
            padding = padding,
            onSplashFinished = onSplashFinished,
        )
    }
}
