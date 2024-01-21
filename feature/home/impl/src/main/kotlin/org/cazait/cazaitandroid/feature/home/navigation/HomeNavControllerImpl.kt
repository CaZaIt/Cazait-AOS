package org.cazait.cazaitandroid.feature.home.navigation

import androidx.navigation.NavController
import org.cazait.cazaitandroid.feature.home.api.HomeNavController
import org.cazait.cazaitandroid.feature.home.api.HomeNavControllerInfo
import javax.inject.Inject

internal class HomeNavControllerImpl @Inject constructor() : HomeNavController {
    override val route: String = HomeRoute.route
    override fun navigate(navController: NavController, navInfo: HomeNavControllerInfo) {
        navController.navigateHome(navInfo.navOptions)
    }
}
