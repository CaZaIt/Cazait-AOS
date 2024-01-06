package org.cazait.cazaitandroid.ui

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.compose.rememberNavController
import dagger.hilt.android.AndroidEntryPoint
import org.cazait.cazaitandroid.MainNavigator
import org.cazait.cazaitandroid.core.designsystem.theme.CazaitTheme
import org.cazait.cazaitandroid.feature.cafedetail.api.CafeDetailNavGraph
import org.cazait.cazaitandroid.rememberMainNavigator
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private val viewModel: MainViewModel by viewModels()

    @Inject
    lateinit var cafeDetailNavGraph: CafeDetailNavGraph

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
                    onChangeDarkTheme = { },
                    cafeDetailNavGraph = cafeDetailNavGraph,
                )
            }
        }
    }
}
