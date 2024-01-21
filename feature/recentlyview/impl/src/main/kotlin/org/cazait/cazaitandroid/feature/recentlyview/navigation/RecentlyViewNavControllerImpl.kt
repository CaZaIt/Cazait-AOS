package org.cazait.cazaitandroid.feature.recentlyview.navigation

import androidx.navigation.NavController
import org.cazait.cazaitandroid.feature.recentlyview.api.RecentlyViewNavController
import javax.inject.Inject

class RecentlyViewNavControllerImpl @Inject constructor() : RecentlyViewNavController {
    override val route: String = RecentlyViewRoute.route

    override fun navigate(navController: NavController, navInfo: Unit) {
        navController.navigateRecentlyView()
    }
}
