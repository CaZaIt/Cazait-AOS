package org.cazait.cazaitandroid.feature.home.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import org.cazait.cazaitandroid.feature.home.HomeRoute

internal fun NavController.navigateHome(navOptions: NavOptions) {
    navigate(HomeRoute.route, navOptions)
}

internal fun NavGraphBuilder.homeNavGraph(
    padding: PaddingValues,
    onCafeClick: (cafeId: String) -> Unit,
    onShowErrorSnackbar: (throwable: Throwable?) -> Unit,
) {
    composable(route = HomeRoute.route) {
        HomeRoute(
            padding = padding,
            onCafeClick = onCafeClick,
            onShowErrorSnackbar = onShowErrorSnackbar,
        )
    }
}

internal object HomeRoute {
    const val route: String = "home"
}
