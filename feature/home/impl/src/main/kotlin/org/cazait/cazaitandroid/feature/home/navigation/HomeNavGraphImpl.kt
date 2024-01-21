package org.cazait.cazaitandroid.feature.home.navigation

import androidx.navigation.NavGraphBuilder
import org.cazait.cazaitandroid.feature.home.api.HomeNavGraph
import org.cazait.cazaitandroid.feature.home.api.HomeNavGraphInfo
import javax.inject.Inject

internal class HomeNavGraphImpl @Inject constructor() : HomeNavGraph {
    override fun buildNavGraph(navGraphBuilder: NavGraphBuilder, navInfo: HomeNavGraphInfo) {
        navGraphBuilder.homeNavGraph(
            padding = navInfo.padding,
            onCafeClick = navInfo.onCafeClick,
            onShowErrorSnackbar = navInfo.onShowErrorSnackbar,
        )
    }
}
