package org.cazait.cazaitandroid.feature.viewmore.navigation

import org.cazait.cazaitandroid.feature.nav.CazaitTab
import org.cazait.cazaitandroid.feature.viewmore.R
import javax.inject.Inject

internal class ViewMoreTab @Inject constructor() : CazaitTab {
    override val iconResId: Int = R.drawable.ic_view_more
    override val iconResIdSelected: Int = R.drawable.ic_view_more_selected
    override val contentDescription: String = ViewMoreRoute.route
    override val route: String = ViewMoreRoute.route
    override val order: Int = 4
    override val isStartDestination: Boolean = false
}
