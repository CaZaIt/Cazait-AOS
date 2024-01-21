package org.cazait.cazaitandroid.feature.viewmore.navigation

import androidx.navigation.NavController
import org.cazait.cazaitandroid.feature.viewmore.api.ViewMoreNavController
import org.cazait.cazaitandroid.feature.viewmore.api.ViewMoreNavControllerInfo
import javax.inject.Inject

internal class ViewMoreNavControllerImpl @Inject constructor() : ViewMoreNavController {
    override val route: String = ViewMoreRoute.route

    override fun navigate(navController: NavController, navInfo: ViewMoreNavControllerInfo) {
        navController.navigateViewMore(navInfo.navOptions)
    }
}
