package org.cazait.cazaitandroid.feature.cafedetail.navigation

import androidx.navigation.NavGraphBuilder
import org.cazait.cazaitandroid.feature.cafedetail.api.CafeDetailNavGraph
import org.cazait.cazaitandroid.feature.cafedetail.api.CafeDetailNavGraphInfo
import javax.inject.Inject

internal class CafeDetailNavGraphImpl @Inject constructor() : CafeDetailNavGraph {
    override fun buildNavGraph(navGraphBuilder: NavGraphBuilder, navInfo: CafeDetailNavGraphInfo) {
        navGraphBuilder.cafeDetailNavGraph(
            navInfo.onEditReviewClick,
            navInfo.onBackButtonClick,
            navInfo.onNavArgError,
            navInfo.onShowErrorSnackbar,
        )
    }
}
