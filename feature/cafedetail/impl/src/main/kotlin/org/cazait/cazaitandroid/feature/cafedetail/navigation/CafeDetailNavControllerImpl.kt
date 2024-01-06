package org.cazait.cazaitandroid.feature.cafedetail.navigation

import androidx.navigation.NavController
import org.cazait.cazaitandroid.feature.cafedetail.api.CafeDetailNavController
import org.cazait.cazaitandroid.feature.cafedetail.api.CafeDetailNavControllerInfo
import javax.inject.Inject

internal class CafeDetailNavControllerImpl @Inject constructor() : CafeDetailNavController {
    override fun navigate(navController: NavController, navInfo: CafeDetailNavControllerInfo) {
        navController.navigateCafeDetail(navInfo.cafeId)
    }
}