package org.cazait.cazaitandroid.feature.main

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.navigation.NavDestination
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navOptions
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import org.cazait.cazaitandroid.feature.cafedetail.api.CafeDetailNavController
import org.cazait.cazaitandroid.feature.cafedetail.api.CafeDetailNavControllerInfo
import org.cazait.cazaitandroid.feature.cafedetail.api.ReviewEditorNavController
import org.cazait.cazaitandroid.feature.cafedetail.api.ReviewEditorNavControllerInfo
import org.cazait.cazaitandroid.feature.home.api.HomeNavController
import org.cazait.cazaitandroid.feature.home.api.HomeNavControllerInfo
import org.cazait.cazaitandroid.feature.map.api.MapNavController
import org.cazait.cazaitandroid.feature.map.api.MapNavControllerInfo
import org.cazait.cazaitandroid.feature.mypage.api.MyPageNavController
import org.cazait.cazaitandroid.feature.mypage.api.MyPageNavControllerInfo
import org.cazait.cazaitandroid.feature.nav.CazaitTab
import org.cazait.cazaitandroid.feature.recentlyview.api.RecentlyViewNavController
import org.cazait.cazaitandroid.feature.signin.navigateSignIn
import org.cazait.cazaitandroid.feature.splash.SplashNav
import org.cazait.cazaitandroid.feature.viewmore.api.ViewMoreNavController
import org.cazait.cazaitandroid.feature.viewmore.api.ViewMoreNavControllerInfo
import javax.inject.Inject

internal class MainNavigator(
    val navController: NavHostController,
    private val homeNavController: HomeNavController,
    private val mapNavController: MapNavController,
    private val myPageNavController: MyPageNavController,
    private val cafeDetailNavController: CafeDetailNavController,
    private val reviewEditorNavController: ReviewEditorNavController,
    private val viewMoreNavController: ViewMoreNavController,
    private val recentlyViewNavController: RecentlyViewNavController,
    private val mainTabs: MainTabs,
) {
    private val currentDestination: NavDestination?
        @Composable get() = navController
            .currentBackStackEntryAsState().value?.destination

    private val _startNavigate = MutableStateFlow(SplashNav.route)
    val startDestination = _startNavigate.asStateFlow()

    val currentTab: CazaitTab?
        @Composable get() = currentDestination
            ?.route
            ?.let(mainTabs::find)

    fun navigate(tab: CazaitTab) {
        val navOptions = navOptions {
            popUpTo(navController.graph.findStartDestination().id) {
                saveState = true
            }
            launchSingleTop = true
            restoreState = true
        }

        when (tab.route) {
            homeNavController.route -> homeNavController.navigate(
                navController,
                HomeNavControllerInfo(navOptions),
            )

            mapNavController.route -> mapNavController.navigate(
                navController,
                MapNavControllerInfo(navOptions),
            )

            myPageNavController.route -> myPageNavController.navigate(
                navController,
                MyPageNavControllerInfo(navOptions),
            )

            viewMoreNavController.route -> viewMoreNavController.navigate(
                navController,
                ViewMoreNavControllerInfo(navOptions),
            )
        }
    }

    fun popBackStack() {
        navController.popBackStack()
    }

    fun navigateSignIn() {
        navController.navigateSignIn()
    }

    fun navigateHome() {
        _startNavigate.update { mainTabs.startDestination }
//        mainTabs.find(homeNavController.route)?.let(::navigate)
    }

    fun navigateCafeDetail(cafeId: String) {
        cafeDetailNavController.navigate(
            navController = navController,
            navInfo = CafeDetailNavControllerInfo(cafeId),
        )
    }

    fun navigateReviewEditor(cafeId: String) {
        reviewEditorNavController.navigate(
            navController = navController,
            navInfo = ReviewEditorNavControllerInfo(cafeId),
        )
    }

    fun navigateRecentlyView() {
        recentlyViewNavController.navigate(
            navController = navController,
            navInfo = Unit,
        )
    }

    @Composable
    fun shouldShowBottomBar(): Boolean {
        val currentRoute = currentDestination?.route ?: return false
        return currentRoute in mainTabs
    }

    class Factory @Inject constructor(
        private val homeNavController: HomeNavController,
        private val mapNavController: MapNavController,
        private val myPageNavController: MyPageNavController,
        private val viewMoreNavController: ViewMoreNavController,
        private val cafeDetailNavController: CafeDetailNavController,
        private val reviewEditorNavController: ReviewEditorNavController,
        private val recentlyViewNavController: RecentlyViewNavController,
        private val mainTabs: MainTabs,
    ) {
        fun create(navController: NavHostController): MainNavigator {
            return MainNavigator(
                navController = navController,
                homeNavController = homeNavController,
                mapNavController = mapNavController,
                myPageNavController = myPageNavController,
                viewMoreNavController = viewMoreNavController,
                cafeDetailNavController = cafeDetailNavController,
                reviewEditorNavController = reviewEditorNavController,
                recentlyViewNavController = recentlyViewNavController,
                mainTabs = mainTabs,
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
