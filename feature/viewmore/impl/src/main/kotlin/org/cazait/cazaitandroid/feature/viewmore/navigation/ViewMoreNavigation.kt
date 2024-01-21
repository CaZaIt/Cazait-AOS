package org.cazait.cazaitandroid.feature.viewmore.navigation

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable

internal fun NavController.navigateViewMore(navOptions: NavOptions) {
    navigate(ViewMoreRoute.route, navOptions)
}

internal fun NavGraphBuilder.viewMoreNavGraph(
    padding: PaddingValues,
//    onShowErrorSnackbar: (throwable: Throwable?) -> Unit,
) {
    composable(route = ViewMoreRoute.route) {
        Box(
            modifier = Modifier.padding(padding).fillMaxSize(),
        ) {
        }
    }
}

internal object ViewMoreRoute {
    const val route: String = "view_more"
}
