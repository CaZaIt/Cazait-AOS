package org.cazait.cazaitandroid.feature.map.navigation

import androidx.navigation.NavGraphBuilder
import org.cazait.cazaitandroid.feature.map.api.MapNavGraph
import org.cazait.cazaitandroid.feature.map.api.MapNavGraphInfo
import javax.inject.Inject

class MapNavGraphImpl @Inject constructor() : MapNavGraph {
    override fun buildNavGraph(navGraphBuilder: NavGraphBuilder, navInfo: MapNavGraphInfo) {
        navGraphBuilder.mapNavGraph(
            navInfo.padding,
            navInfo.onShowErrorSnackbar,
        )
    }
}
