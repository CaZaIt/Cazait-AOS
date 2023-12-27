package org.cazait.cazaitandroid.feature.home

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable

object HomeNav {
    val iconResId = R.drawable.ic_home
    val iconResIdSelected = R.drawable.ic_home_selected
    const val route: String = "home"
}

fun NavController.navigateHome(navOptions: NavOptions) {
    navigate(HomeNav.route, navOptions)
}

fun NavGraphBuilder.homeNavGraph(
//    padding: PaddingValues,
//    onCafeClick: () -> Unit,
//    onShowErrorSnackbar: (throwable: Throwable?) -> Unit,
) {
    composable(route = HomeNav.route) {}
}
