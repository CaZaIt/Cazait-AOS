package org.cazait.cazaitandroid.feature.main

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.compose.rememberNavController
import dagger.hilt.android.AndroidEntryPoint
import org.cazait.cazaitandroid.core.designsystem.theme.CazaitTheme
import org.cazait.cazaitandroid.feature.cafedetail.api.CafeDetailNavGraph
import org.cazait.cazaitandroid.feature.home.api.HomeNavGraph
import org.cazait.cazaitandroid.feature.map.api.MapNavGraph
import org.cazait.cazaitandroid.feature.mypage.api.MyPageNavGraph
import org.cazait.cazaitandroid.feature.recentlyview.api.RecentlyViewNavGraph
import org.cazait.cazaitandroid.feature.viewmore.api.ViewMoreNavGraph
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    // private val viewModel: MainViewModel by viewModels()

    @Inject
    lateinit var homeNavGraph: HomeNavGraph

    @Inject
    lateinit var mapNavGraph: MapNavGraph

    @Inject
    lateinit var cafeDetailNavGraph: CafeDetailNavGraph

    @Inject
    lateinit var myPageNavGraph: MyPageNavGraph

    @Inject
    lateinit var viewMoreNavGraph: ViewMoreNavGraph

    @Inject
    lateinit var recentlyViewNavGraph: RecentlyViewNavGraph

    @Inject
    lateinit var mainTabs: MainTabs

    @Inject
    internal lateinit var mainNavigatorFactory: MainNavigator.Factory

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            // val isDarkTheme = false
            val navigator: MainNavigator = rememberMainNavigator(
                rememberNavController(),
                mainNavigatorFactory = mainNavigatorFactory,
            )

            CazaitTheme {
                MainScreen(
                    navigator = navigator,
//                    onChangeDarkTheme = { },
                    homeNavGraph = homeNavGraph,
                    mapNavGraph = mapNavGraph,
                    myPageNavGraph = myPageNavGraph,
                    cafeDetailNavGraph = cafeDetailNavGraph,
                    viewMoreNavGraph = viewMoreNavGraph,
                    recentlyViewNavGraph = recentlyViewNavGraph,
                    mainTabs = mainTabs,
                )
            }
        }
    }
}
