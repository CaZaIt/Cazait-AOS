package org.cazait.cazaitandroid.feature.mypage.navigation

import androidx.navigation.NavController
import org.cazait.cazaitandroid.feature.mypage.api.MyPageNavController
import org.cazait.cazaitandroid.feature.mypage.api.MyPageNavControllerInfo
import javax.inject.Inject

internal class MyPageNavControllerImpl @Inject constructor() : MyPageNavController {
    override val route: String = MyPageRoute.route
    override fun navigate(navController: NavController, navInfo: MyPageNavControllerInfo) {
        navController.navigateMyPage(navInfo.navOptions)
    }
}
