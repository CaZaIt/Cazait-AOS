package org.cazait.cazaitandroid.feature.recentlyview.navigation

import androidx.navigation.NavGraphBuilder
import org.cazait.cazaitandroid.feature.recentlyview.api.RecentlyViewNavGraph
import org.cazait.cazaitandroid.feature.recentlyview.api.RecentlyViewNavGraphInfo
import javax.inject.Inject

class RecentlyViewNavGraphImpl @Inject constructor() : RecentlyViewNavGraph {
    override fun buildNavGraph(
        navGraphBuilder: NavGraphBuilder,
        navInfo: RecentlyViewNavGraphInfo,
    ) {
        navGraphBuilder.recentlyViewNavGraph(
            onCafeClick = navInfo.onCafeClick,
            onBackButtonClick = navInfo.onBackButtonClick,
        )
    }
}
