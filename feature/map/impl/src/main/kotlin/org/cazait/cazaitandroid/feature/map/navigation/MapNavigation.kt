package org.cazait.cazaitandroid.feature.map.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import org.cazait.cazaitandroid.feature.map.MapRoute

internal fun NavController.navigateMap(navOptions: NavOptions) {
    navigate(MapRoute.route, navOptions)
}

internal fun NavGraphBuilder.mapNavGraph(
    padding: PaddingValues,
//    onCafeClick: () -> Unit,
    onShowErrorSnackbar: (throwable: Throwable?) -> Unit,
) {
    composable(route = MapRoute.route) {
        MapRoute(
            padding = padding,
            onShowErrorSnackbar = onShowErrorSnackbar,
        )
    }
}

internal object MapRoute {
    const val route: String = "map"
}
