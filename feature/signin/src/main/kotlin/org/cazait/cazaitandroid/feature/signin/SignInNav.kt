package org.cazait.cazaitandroid.feature.signin

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable

internal object SignInNav {
    const val route: String = "signIn"
}

fun NavController.navigateSignIn() {
    navigate(SignInNav.route)
}

fun NavGraphBuilder.signInNavGraph(
    onShowErrorSnackbar: (throwable: Throwable?) -> Unit,
) {
    composable(route = SignInNav.route) {
        SignInRoute(onShowErrorSnackbar)
    }
}
