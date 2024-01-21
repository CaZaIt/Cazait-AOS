package org.cazait.cazaitandroid.feature.recentlyview.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import org.cazait.cazaitandroid.feature.recentlyview.RecentlyViewedCafeRoute

internal fun NavController.navigateRecentlyView() {
    navigate(RecentlyViewRoute.route)
}

internal fun NavGraphBuilder.recentlyViewNavGraph(
    onCafeClick: (cafeId: String) -> Unit,
    onBackButtonClick: () -> Unit,
) {
    composable(route = RecentlyViewRoute.route) {
        RecentlyViewedCafeRoute(
            onCafeClick = onCafeClick,
            onBackButtonClick = onBackButtonClick,
        )
    }
}

internal object RecentlyViewRoute {
    const val route = "recentlyview"
}
