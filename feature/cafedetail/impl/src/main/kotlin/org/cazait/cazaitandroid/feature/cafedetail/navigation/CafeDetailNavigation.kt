package org.cazait.cazaitandroid.feature.cafedetail.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import androidx.navigation.navOptions
import org.cazait.cazaitandroid.feature.cafedetail.CafeDetailRoute
import org.cazait.cazaitandroid.feature.cafedetail.ReviewEditorScreen
import java.util.UUID

internal fun NavController.navigateCafeDetail(cafeId: String) {
    navigate(CafeDetailRoute.createRoute(cafeId), navOptions { restoreState = true })
}

internal fun NavController.navigateReviewEditor(cafeId: String) {
    navigate(ReviewEditorRoute.createRoute(cafeId))
}

internal fun NavGraphBuilder.cafeDetailNavGraph(
    onEditReviewClick: (cafeId: String) -> Unit,
    onBackButtonClick: () -> Unit,
    onNavArgError: () -> Unit,
    onShowErrorSnackbar: (throwable: Throwable?) -> Unit,
) {
    composable(
        route = CafeDetailRoute.createRoute("{cafeId}"),
        arguments = listOf(
            navArgument("cafeId") {
                type = NavType.StringType
            },
        ),
    ) { navBackStackEntry ->
        runCatching {
            UUID.fromString(navBackStackEntry.arguments?.getString("cafeId"))
        }.onFailure {
            onShowErrorSnackbar(it)
            onNavArgError()
        }.onSuccess { cafeId ->
            CafeDetailRoute(
                cafeId,
                onEditReviewClick = onEditReviewClick,
                onShowErrorSnackbar = onShowErrorSnackbar,
            )
        }
    }

    composable(
        route = ReviewEditorRoute.createRoute("{cafeId}"),
        arguments = listOf(
            navArgument("cafeId") {
                type = NavType.StringType
            },
        ),
    ) { navBackStackEntry ->
        runCatching {
            UUID.fromString(navBackStackEntry.arguments?.getString("cafeId"))
        }.onFailure {
            onShowErrorSnackbar(it)
            onNavArgError()
        }.onSuccess {
            ReviewEditorScreen(
//                cafeId,
                onBackButtonClick = onBackButtonClick,
//                onShowErrorSnackbar = onShowErrorSnackbar
            )
        }
    }
}

internal object CafeDetailRoute {
    const val route: String = "cafeDetail"
    fun createRoute(cafeId: String): String = "$route/$cafeId"
}

internal object ReviewEditorRoute {
    private const val route: String = "reviewEditor"
    fun createRoute(cafeId: String): String = "$route/$cafeId"
}
