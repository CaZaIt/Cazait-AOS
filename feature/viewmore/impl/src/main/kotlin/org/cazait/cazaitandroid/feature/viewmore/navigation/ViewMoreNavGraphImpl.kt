package org.cazait.cazaitandroid.feature.viewmore.navigation

import androidx.navigation.NavGraphBuilder
import org.cazait.cazaitandroid.feature.viewmore.api.ViewMoreNavGraph
import org.cazait.cazaitandroid.feature.viewmore.api.ViewMoreNavGraphInfo
import javax.inject.Inject

class ViewMoreNavGraphImpl @Inject constructor() : ViewMoreNavGraph {
    override fun buildNavGraph(navGraphBuilder: NavGraphBuilder, navInfo: ViewMoreNavGraphInfo) {
        navGraphBuilder.viewMoreNavGraph(
            padding = navInfo.padding,
//            onShowErrorSnackbar = navInfo.onShowErrorSnackbar,
        )
    }
}
