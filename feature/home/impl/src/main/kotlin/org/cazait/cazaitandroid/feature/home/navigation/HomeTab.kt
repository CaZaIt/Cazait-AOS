package org.cazait.cazaitandroid.feature.home.navigation

import org.cazait.cazaitandroid.feature.home.R
import org.cazait.cazaitandroid.feature.nav.CazaitTab
import javax.inject.Inject

internal class HomeTab @Inject constructor() : CazaitTab {
    override val iconResId: Int = R.drawable.ic_home
    override val iconResIdSelected: Int = R.drawable.ic_home_selected
    override val contentDescription: String = HomeRoute.route
    override val route: String = HomeRoute.route
    override val order: Int = 1
    override val isStartDestination: Boolean = true
}
