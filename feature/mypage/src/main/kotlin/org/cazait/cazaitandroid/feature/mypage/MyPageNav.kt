package org.cazait.cazaitandroid.feature.mypage

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable

object MyPageNav {
    val iconResId = R.drawable.ic_my_page
    val iconResIdSelected = R.drawable.ic_my_page_selected
    const val route: String = "my_page"
}

fun NavController.navigateMyPage(navOptions: NavOptions) {
    navigate(MyPageNav.route, navOptions)
}

fun NavGraphBuilder.myPageNavGraph(
//    padding: PaddingValues,
//    onCafeClick: () -> Unit,
//    onShowErrorSnackbar: (throwable: Throwable?) -> Unit,
) {
    composable(route = MyPageNav.route) {}
}
