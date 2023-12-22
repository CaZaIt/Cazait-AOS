package org.cazait.cazaitandroid.feature.signin

import androidx.compose.foundation.layout.PaddingValues
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable

object SignInNav {
    val route: String = "sign_in"
}

fun NavController.navigateSignIn(navOptions: NavOptions) {
    navigate(SignInNav.route, navOptions)
}

fun NavGraphBuilder.SignInNavGraph(
    padding: PaddingValues,
    onCafeClick: () -> Unit,
) {
    composable(route = SignInNav.route) {

    }
}