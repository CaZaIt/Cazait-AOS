package org.cazait.cazaitandroid.feature.signin

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import androidx.navigation.navOptions

internal object SignInNav {
    const val route: String = "signIn"
}

fun NavController.navigateSignIn() {
    navigate(SignInNav.route, navOptions = navOptions {
        popUpTo(graph.startDestinationId) { inclusive = true}
        launchSingleTop = true
    })
}

fun NavGraphBuilder.signInNavGraph(
    onShowErrorSnackbar: (throwable: Throwable?) -> Unit,
) {
    composable(route = SignInNav.route) {
        SignInRoute(onShowErrorSnackbar)
    }
}
