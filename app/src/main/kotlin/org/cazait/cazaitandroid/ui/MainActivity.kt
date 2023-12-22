package org.cazait.cazaitandroid.ui

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import dagger.hilt.android.AndroidEntryPoint
import org.cazait.cazaitandroid.MainNavigator
import org.cazait.cazaitandroid.core.designsystem.theme.CazaitTheme
import org.cazait.cazaitandroid.rememberMainNavigator

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private val viewModel: MainViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            // val isDarkTheme = false
            val navigator: MainNavigator = rememberMainNavigator()

            CazaitTheme {
                MainScreen(
                    navigator = navigator,
                    onChangeDarkTheme = { },
                )
            }
        }
    }
}
