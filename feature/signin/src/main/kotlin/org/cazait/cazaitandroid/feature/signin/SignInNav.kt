package org.cazait.cazaitandroid.feature.signin

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navOptions

internal object SignInNav {
    const val route: String = "signIn"
}

fun NavController.navigateSignIn() {
    navigate(
        route = SignInNav.route,
        navOptions = navOptions {
            popUpTo(graph.startDestinationId) { inclusive = true }
            launchSingleTop = true
        },
    )
}

fun NavGraphBuilder.signInNavGraph(
    onSignInSuccess: () -> Unit,
    onShowErrorSnackbar: (throwable: Throwable?) -> Unit,
) {
    composable(route = SignInNav.route) {
        SignInRoute(
            onSignInSuccess = onSignInSuccess,
            onShowErrorSnackbar = onShowErrorSnackbar
        )
    }
}
