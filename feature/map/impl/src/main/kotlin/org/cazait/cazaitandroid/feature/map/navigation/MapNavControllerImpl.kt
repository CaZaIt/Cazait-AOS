package org.cazait.cazaitandroid.feature.map.navigation

import androidx.navigation.NavController
import org.cazait.cazaitandroid.feature.map.api.MapNavController
import org.cazait.cazaitandroid.feature.map.api.MapNavControllerInfo
import javax.inject.Inject

internal class MapNavControllerImpl @Inject constructor() : MapNavController {
    override val route: String = MapRoute.route
    override fun navigate(navController: NavController, navInfo: MapNavControllerInfo) {
        navController.navigateMap(
            navInfo.navOptions,
        )
    }
}
