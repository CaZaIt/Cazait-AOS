package org.cazait.cazaitandroid.feature.splash

import android.content.res.Configuration
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.tween
import androidx.compose.animation.expandIn
import androidx.compose.animation.fadeIn
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.IntSize
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.delay
import org.cazait.cazaitandroid.core.designsystem.theme.CazaitTheme
import org.cazait.cazaitandroid.feature.splash.components.AppDescriptionCard

@Composable
internal fun SplashScreen(
    onClickStart: () -> Unit,
) {
    var showImage by remember { mutableStateOf(false) }
    val imageEnterTransition = fadeIn(animationSpec = tween(durationMillis = 3000)) + expandIn()
    var showBottomBar by remember { mutableStateOf(false) }
    val descriptionCardEnterTransition =
        fadeIn(animationSpec = tween(durationMillis = 3000)) + expandIn(
            expandFrom = Alignment.BottomCenter,
            initialSize = { IntSize(it.width, 0) },
        )

    LaunchedEffect(Unit) {
        showImage = true
        delay(1500)
        showBottomBar = true
    }

    Scaffold(
        modifier = Modifier.background(MaterialTheme.colorScheme.background),
        content = { paddingValues ->
            Box(
                modifier = Modifier
                    .padding(paddingValues)
                    .fillMaxSize(),
            ) {
                AnimatedVisibility(
                    modifier = Modifier.align(Alignment.Center),
                    visible = showImage,
                    enter = imageEnterTransition,
                ) {
                    Image(
                        imageVector = ImageVector.vectorResource(
                            id = org.cazait.cazaitandroid.core.ui.R.drawable.logo_cazait_main,
                        ),
                        contentDescription = "logo",
                        modifier = Modifier
                            .align(Alignment.Center)
                            .size(142.dp),
                    )
                }
            }
        },
        bottomBar = {
            AnimatedVisibility(
                visible = showBottomBar,
                enter = descriptionCardEnterTransition,
            ) {
                AppDescriptionCard(
                    modifier = Modifier.fillMaxWidth(),
                    onClickStart = onClickStart,
                )
            }
        },
    )
}

@Composable
@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES)
@Preview(uiMode = Configuration.UI_MODE_NIGHT_NO)
private fun SplashScreenPreview() {
    CazaitTheme {
        SplashScreen(
            onClickStart = {},
        )
    }
}
