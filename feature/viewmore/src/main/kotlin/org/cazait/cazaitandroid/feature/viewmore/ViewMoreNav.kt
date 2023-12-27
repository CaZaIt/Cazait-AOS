package org.cazait.cazaitandroid.feature.viewmore

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable

object ViewMoreNav {
    val iconResId = R.drawable.ic_view_more
    val iconResIdSelected = R.drawable.ic_view_more_selected
    const val route: String = "view_more"
}

fun NavController.navigateViewMore(navOptions: NavOptions) {
    navigate(ViewMoreNav.route, navOptions)
}

fun NavGraphBuilder.viewMoreNavGraph(
//    padding: PaddingValues,
//    onShowErrorSnackbar: (throwable: Throwable?) -> Unit,
) {
    composable(route = ViewMoreNav.route) {}
}
