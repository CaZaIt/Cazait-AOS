package org.cazait.cazaitandroid

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.navigation.NavDestination
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navOptions
import org.cazait.cazaitandroid.feature.cafedetail.api.CafeDetailNavController
import org.cazait.cazaitandroid.feature.cafedetail.api.CafeDetailNavControllerInfo
import org.cazait.cazaitandroid.feature.home.HomeNav
import org.cazait.cazaitandroid.feature.home.navigateHome
import org.cazait.cazaitandroid.feature.map.navigateMap
import org.cazait.cazaitandroid.feature.mypage.navigateMyPage
import org.cazait.cazaitandroid.feature.signin.navigateSignIn
import org.cazait.cazaitandroid.feature.splash.SplashNav
import org.cazait.cazaitandroid.feature.viewmore.navigateViewMore
import javax.inject.Inject

internal class MainNavigator(
    val navController: NavHostController,
    private val cafeDetailNavController: CafeDetailNavController,
) {
    private val currentDestination: NavDestination?
        @Composable get() = navController
            .currentBackStackEntryAsState().value?.destination

    var startDestination = SplashNav.route
        private set

    val currentTab: MainTab?
        @Composable get() = currentDestination
            ?.route
            ?.let(MainTab::find)

    fun navigate(tab: MainTab) {
        val navOptions = navOptions {
            popUpTo(navController.graph.findStartDestination().id) {
                saveState = true
            }
            launchSingleTop = true
            restoreState = true
        }

        when (tab) {
            MainTab.HOME -> navController.navigateHome(navOptions)
            MainTab.MAP -> navController.navigateMap(navOptions)
            MainTab.MY_PAGE -> navController.navigateMyPage(navOptions)
            MainTab.VIEW_MORE -> navController.navigateViewMore(navOptions)
        }
    }

    fun popBackStack() {
        navController.popBackStack()
    }

    fun navigateSignIn() {
        navController.navigateSignIn()
    }

    fun navigateCafeDetail(cafeId: String) {
        cafeDetailNavController.navigate(
            navController = navController,
            navInfo = CafeDetailNavControllerInfo(cafeId),
        )
    }

    fun navigateHome() {
        startDestination = HomeNav.route
        navController.navigateHome(navOptions {
            popUpTo(HomeNav.route) {
                inclusive = true
            }
            launchSingleTop = true
        })
    }

    @Composable
    fun shouldShowBottomBar(): Boolean {
        val currentRoute = currentDestination?.route ?: return false
        return currentRoute in MainTab
    }

    class Factory @Inject constructor(
        private val cafeDetailNavController: CafeDetailNavController,
    ) {
        fun create(navController: NavHostController) : MainNavigator {
            return MainNavigator(
                navController = navController,
                cafeDetailNavController = cafeDetailNavController,
            )
        }
    }
}

@Composable
internal fun rememberMainNavigator(
    navController: NavHostController = rememberNavController(),
    mainNavigatorFactory: MainNavigator.Factory,
): MainNavigator = remember(navController) {
    mainNavigatorFactory.create(navController = navController)
}
