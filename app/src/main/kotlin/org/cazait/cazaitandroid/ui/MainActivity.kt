package org.cazait.cazaitandroid.ui

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import dagger.hilt.android.AndroidEntryPoint
import org.cazait.cazaitandroid.core.designsystem.theme.CazaitTheme

@AndroidEntryPoint
class MainActivity: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            CazaitTheme {
                Surface {
                    Text(text = "hello cazait")
                }
            }
        }
    }
}