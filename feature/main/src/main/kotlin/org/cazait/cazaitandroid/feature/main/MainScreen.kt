package org.cazait.cazaitandroid.feature.main

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideIn
import androidx.compose.animation.slideOut
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.selection.selectable
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.NavHost
import com.cazait.cazaitandroid.feature.main.R
import kotlinx.collections.immutable.PersistentList
import kotlinx.collections.immutable.toPersistentList
import kotlinx.coroutines.launch
import org.cazait.cazaitandroid.core.designsystem.theme.surfaceDim
import org.cazait.cazaitandroid.feature.cafedetail.api.CafeDetailNavGraph
import org.cazait.cazaitandroid.feature.cafedetail.api.CafeDetailNavGraphInfo
import org.cazait.cazaitandroid.feature.home.api.HomeNavGraph
import org.cazait.cazaitandroid.feature.home.api.HomeNavGraphInfo
import org.cazait.cazaitandroid.feature.map.api.MapNavGraph
import org.cazait.cazaitandroid.feature.map.api.MapNavGraphInfo
import org.cazait.cazaitandroid.feature.mypage.api.MyPageNavGraph
import org.cazait.cazaitandroid.feature.mypage.api.MyPageNavGraphInfo
import org.cazait.cazaitandroid.feature.nav.CazaitTab
import org.cazait.cazaitandroid.feature.recentlyview.api.RecentlyViewNavGraph
import org.cazait.cazaitandroid.feature.recentlyview.api.RecentlyViewNavGraphInfo
import org.cazait.cazaitandroid.feature.signin.signInNavGraph
import org.cazait.cazaitandroid.feature.splash.splashNavGraph
import org.cazait.cazaitandroid.feature.viewmore.api.ViewMoreNavGraph
import org.cazait.cazaitandroid.feature.viewmore.api.ViewMoreNavGraphInfo
import java.net.UnknownHostException

@Composable
internal fun MainScreen(
    navigator: MainNavigator,
//    onChangeDarkTheme: (Boolean) -> Unit,
    homeNavGraph: HomeNavGraph,
    mapNavGraph: MapNavGraph,
    cafeDetailNavGraph: CafeDetailNavGraph,
    myPageNavGraph: MyPageNavGraph,
    viewMoreNavGraph: ViewMoreNavGraph,
    recentlyViewNavGraph: RecentlyViewNavGraph,
    mainTabs: MainTabs,
) {
    val snackbarHostState = remember { SnackbarHostState() }
    val coroutineScope = rememberCoroutineScope()
    val localContextResource = LocalContext.current.resources
    val onShowErrorSnackbar: (throwable: Throwable?) -> Unit = { throwable ->
        coroutineScope.launch {
            snackbarHostState.showSnackbar(
                when (throwable) {
                    is UnknownHostException -> localContextResource.getString(R.string.error_message_network)
                    else -> localContextResource.getString(R.string.error_message_unknown)
                },
            )
        }
    }
    val onShowHttpErrorSnackbar: (stringResId: Int) -> Unit = { stringResId ->
        coroutineScope.launch {
            snackbarHostState.showSnackbar(
                localContextResource.getString(stringResId),
            )
        }
    }

    Scaffold(
        content = { padding ->
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(MaterialTheme.colorScheme.surfaceDim),
            ) {
                NavHost(
                    navController = navigator.navController,
                    startDestination = navigator.startDestination,
                ) {
                    homeNavGraph.buildNavGraph(
                        navGraphBuilder = this,
                        navInfo = HomeNavGraphInfo(
                            padding = padding,
                            onCafeClick = { navigator.navigateCafeDetail(it) },
                            onShowErrorSnackbar = onShowErrorSnackbar,
                        ),
                    )
                    mapNavGraph.buildNavGraph(
                        navGraphBuilder = this,
                        navInfo = MapNavGraphInfo(
                            padding = padding,
                            onCafeClick = { navigator.navigateCafeDetail(it) },
                            onShowErrorSnackbar = onShowErrorSnackbar,
                        ),
                    )
                    myPageNavGraph.buildNavGraph(
                        navGraphBuilder = this,
                        navInfo = MyPageNavGraphInfo(
                            padding = padding,
                            onSignIn = { navigator.navigateSignIn() },
                            onRecentlyViewedCafeClick = { navigator.navigateRecentlyView() },
                            onShowErrorSnackbar = onShowErrorSnackbar,
                        ),
                    )

                    splashNavGraph(
                        onClickStart = { navigator.navigateSignIn() },
                        onUserInformationStored = { navigator.navigateHome() },
                    )
                    signInNavGraph(
                        onSignInSuccess = { navigator.navigateHome() },
                        onShowHttpErrorSnackbar = onShowHttpErrorSnackbar,
                        onShowErrorSnackbar = onShowErrorSnackbar,
                    )
                    cafeDetailNavGraph.buildNavGraph(
                        navGraphBuilder = this,
                        navInfo = CafeDetailNavGraphInfo(
                            onEditReviewClick = { navigator.navigateReviewEditor(it) },
                            onBackButtonClick = { navigator.popBackStack() },
                            onNavArgError = { navigator.popBackStack() },
                            onShowErrorSnackbar = onShowErrorSnackbar,
                        ),
                    )
                    viewMoreNavGraph.buildNavGraph(
                        navGraphBuilder = this,
                        navInfo = ViewMoreNavGraphInfo(
                            padding,
//                            onShowErrorSnackbar,
                        ),
                    )
                    recentlyViewNavGraph.buildNavGraph(
                        navGraphBuilder = this,
                        navInfo = RecentlyViewNavGraphInfo(
                            onCafeClick = { navigator.navigateRecentlyView() },
                            onBackButtonClick = { navigator.popBackStack() },
                        ),
                    )
                }
            }
        },
        bottomBar = {
            MainBottomBar(
                visible = navigator.shouldShowBottomBar(),
                tabs = mainTabs.tabList.toPersistentList(),
                currentTab = navigator.currentTab,
                onTabSelected = { navigator.navigate(it) },
            )
        },
        snackbarHost = { SnackbarHost(snackbarHostState) },
    )
}

@Composable
fun MainBottomBar(
    visible: Boolean,
    tabs: PersistentList<CazaitTab>,
    currentTab: CazaitTab?,
    onTabSelected: (CazaitTab) -> Unit,
) {
    AnimatedVisibility(
        visible = visible,
        enter = fadeIn() + slideIn { IntOffset(0, it.height) },
        exit = fadeOut() + slideOut { IntOffset(0, it.height) },
    ) {
        Row(
            modifier =
            Modifier
                .navigationBarsPadding()
                .fillMaxWidth()
                .height(56.dp)
                .background(
                    color = MaterialTheme.colorScheme.surface,
                )
                .padding(vertical = 8.dp)
                .padding(horizontal = 28.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp),
        ) {
            tabs.forEach { tab ->
                MainBottomBarItem(
                    tab = tab,
                    selected = tab == currentTab,
                    onClick = { onTabSelected(tab) },
                )
            }
        }
    }
}

@Composable
private fun RowScope.MainBottomBarItem(
    tab: CazaitTab,
    selected: Boolean,
    onClick: () -> Unit,
) {
    Box(
        modifier =
        Modifier
            .weight(1f)
            .fillMaxHeight()
            .selectable(
                selected = selected,
                indication = null,
                interactionSource = remember { MutableInteractionSource() },
                onClick = onClick,
            ),
        contentAlignment = Alignment.Center,
    ) {
        Image(
            imageVector =
            ImageVector.vectorResource(
                if (selected) tab.iconResIdSelected else tab.iconResId,
            ),
            contentDescription = tab.contentDescription,
            modifier = Modifier.size(48.dp),
        )
    }
}
