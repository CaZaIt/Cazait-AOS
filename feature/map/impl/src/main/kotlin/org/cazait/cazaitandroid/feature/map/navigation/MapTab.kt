package org.cazait.cazaitandroid.feature.map.navigation

import org.cazait.cazaitandroid.feature.map.R
import org.cazait.cazaitandroid.feature.nav.CazaitTab
import javax.inject.Inject

internal class MapTab @Inject constructor() : CazaitTab {
    override val iconResId: Int = R.drawable.ic_map
    override val iconResIdSelected: Int = R.drawable.ic_map_selected
    override val contentDescription: String = MapRoute.route
    override val route: String = MapRoute.route
    override val order: Int = 2
    override val isStartDestination: Boolean = false
}
