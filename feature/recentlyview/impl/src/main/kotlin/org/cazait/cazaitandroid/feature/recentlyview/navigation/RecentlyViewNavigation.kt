package org.cazait.cazaitandroid.feature.recentlyview.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import org.cazait.cazaitandroid.feature.recentlyview.RecentlyViewedCafeScreen

internal fun NavController.navigateRecentlyView() {
    navigate(RecentlyViewRoute.route)
}

internal fun NavGraphBuilder.recentlyViewNavGraph(
    onCafeClick: (cafeId: String) -> Unit,
    onBackButtonClick: () -> Unit,
) {
    composable(route = RecentlyViewRoute.route) {
        RecentlyViewedCafeScreen(
            onCafeClick = onCafeClick,
        )
    }
}

internal object RecentlyViewRoute {
    const val route = "recentlyview"
}
