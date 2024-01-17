package org.cazait.cazaitandroid.feature.cafedetail.navigation

import androidx.navigation.NavController
import org.cazait.cazaitandroid.feature.cafedetail.api.CafeDetailNavController
import org.cazait.cazaitandroid.feature.cafedetail.api.CafeDetailNavControllerInfo
import org.cazait.cazaitandroid.feature.cafedetail.api.ReviewEditorNavController
import org.cazait.cazaitandroid.feature.cafedetail.api.ReviewEditorNavControllerInfo
import javax.inject.Inject

internal class CafeDetailNavControllerImpl @Inject constructor() : CafeDetailNavController {
    override fun navigate(navController: NavController, navInfo: CafeDetailNavControllerInfo) {
        navController.navigateCafeDetail(navInfo.cafeId)
    }
}

internal class ReviewEditorNavControllerImpl @Inject constructor() : ReviewEditorNavController {
    override fun navigate(navController: NavController, navInfo: ReviewEditorNavControllerInfo) {
        navController.navigateReviewEditor(navInfo.cafeId)
    }
}
