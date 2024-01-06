package org.cazait.cazaitandroid.feature.cafedetail.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import androidx.navigation.navOptions
import org.cazait.cazaitandroid.feature.cafedetail.CafeDetailRoute
import java.util.UUID

internal fun NavController.navigateCafeDetail(cafeId: String) {
    navigate(CafeDetailNav.route(cafeId), navOptions {
        restoreState = true
    })
}

internal fun NavGraphBuilder.cafeDetailNavGraph(
    onNavArgError: () -> Unit,
    onShowErrorSnackbar: (throwable: Throwable?) -> Unit,
) {
    composable(route = CafeDetailNav.route("{cafeId}"),
        arguments = listOf(
            navArgument("cafeId") {
                type = NavType.StringType
            }
        )
    ) { navBackStackEntry ->
        runCatching {
            UUID.fromString(navBackStackEntry.arguments?.getString("cafeId"))
        }.onFailure {
            onShowErrorSnackbar(it)
            onNavArgError()
        }.onSuccess { cafeId ->
            CafeDetailRoute(
                cafeId,
                onShowErrorSnackbar = onShowErrorSnackbar
            )
        }
    }
}

internal object CafeDetailNav {
    private const val route: String = "cafeDetail"
    fun route(cafeId: String): String = "$route/$cafeId"
}
