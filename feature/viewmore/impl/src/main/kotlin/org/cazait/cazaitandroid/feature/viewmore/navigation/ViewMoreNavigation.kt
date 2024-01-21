package org.cazait.cazaitandroid.feature.viewmore.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import org.cazait.cazaitandroid.feature.viewmore.ViewMoreScreen

internal fun NavController.navigateViewMore(navOptions: NavOptions) {
    navigate(ViewMoreRoute.route, navOptions)
}

internal fun NavGraphBuilder.viewMoreNavGraph(
    padding: PaddingValues,
//    onShowErrorSnackbar: (throwable: Throwable?) -> Unit,
) {
    composable(route = ViewMoreRoute.route) {
        ViewMoreScreen(padding = padding)
    }
}

internal object ViewMoreRoute {
    const val route: String = "view_more"
}
