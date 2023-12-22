package org.cazait.cazaitandroid.feature.map

import androidx.compose.foundation.layout.PaddingValues
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable

object MapNav {
    val iconResId = R.drawable.ic_map
    val iconResIdSelected = R.drawable.ic_map_selected
    val route: String = "map"
}

fun NavController.navigateMap(navOptions: NavOptions) {
    navigate(MapNav.route, navOptions)
}

fun NavGraphBuilder.mapNavGraph(
    padding: PaddingValues,
    onCafeClick: () -> Unit,
    onShowErrorSnackbar: (throwable: Throwable?) -> Unit,
) {
    composable(route = MapNav.route) {
    }
}
