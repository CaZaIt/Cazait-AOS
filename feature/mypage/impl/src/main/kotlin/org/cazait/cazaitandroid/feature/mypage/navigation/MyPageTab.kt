package org.cazait.cazaitandroid.feature.mypage.navigation

import org.cazait.cazaitandroid.feature.mypage.R
import org.cazait.cazaitandroid.feature.nav.CazaitTab
import javax.inject.Inject

internal class MyPageTab @Inject constructor() : CazaitTab {
    override val iconResId: Int = R.drawable.ic_my_page
    override val iconResIdSelected: Int = R.drawable.ic_my_page_selected
    override val contentDescription: String = MyPageRoute.route
    override val route: String = MyPageRoute.route
    override val order: Int = 3
    override val isStartDestination: Boolean = false
}
