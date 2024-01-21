package org.cazait.cazaitandroid.feature.mypage.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import org.cazait.cazaitandroid.feature.mypage.MyPageScreen

internal fun NavController.navigateMyPage(navOptions: NavOptions) {
    navigate(MyPageRoute.route, navOptions)
}

internal object MyPageRoute {
    const val route: String = "my_page"
}

internal fun NavGraphBuilder.myPageNavGraph(
    padding: PaddingValues,
    onShowErrorSnackbar: (throwable: Throwable?) -> Unit,
) {
    composable(route = MyPageRoute.route) {
        MyPageScreen(
            padding = padding,
            onShowErrorSnackbar = onShowErrorSnackbar,
        )
    }
}
