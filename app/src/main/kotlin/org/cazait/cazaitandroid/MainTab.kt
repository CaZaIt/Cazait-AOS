package org.cazait.cazaitandroid

import androidx.annotation.DrawableRes
import org.cazait.cazaitandroid.feature.home.HomeNav
import org.cazait.cazaitandroid.feature.map.MapNav
import org.cazait.cazaitandroid.feature.mypage.MyPageNav
import org.cazait.cazaitandroid.feature.viewmore.ViewMoreNav

enum class MainTab(
    @DrawableRes val iconResId: Int,
    @DrawableRes val iconResIdSelected: Int,
    val contentDescription: String,
    val route: String,
) {
    HOME(
        iconResId = HomeNav.iconResId,
        iconResIdSelected = HomeNav.iconResIdSelected,
        contentDescription = "홈",
        route = HomeNav.route,
    ),
    MAP(
        iconResId = MapNav.iconResId,
        iconResIdSelected = MapNav.iconResIdSelected,
        contentDescription = "맵",
        route = MapNav.route,
    ),
    MY_PAGE(
        iconResId = MyPageNav.iconResId,
        iconResIdSelected = MyPageNav.iconResIdSelected,
        contentDescription = "마이 페이지",
        route = MyPageNav.route,
    ),
    VIEW_MORE(
        iconResId = ViewMoreNav.iconResId,
        iconResIdSelected = ViewMoreNav.iconResIdSelected,
        contentDescription = "더 보기",
        route = ViewMoreNav.route,
    ),

    ;

    companion object {
        operator fun contains(route: String): Boolean {
            return entries.any { it.route == route }
        }

        fun find(route: String): MainTab? {
            return entries.find { it.route == route }
        }
    }
}
