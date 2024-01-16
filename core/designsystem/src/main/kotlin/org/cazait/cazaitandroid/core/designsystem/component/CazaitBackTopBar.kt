package org.cazait.cazaitandroid.core.designsystem.component

import android.content.res.Configuration
import androidx.annotation.StringRes
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarScrollBehavior
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import org.cazait.cazaitandroid.core.designsystem.R
import org.cazait.cazaitandroid.core.designsystem.theme.CazaitTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CazaitBackTopBar(
    title: @Composable () -> Unit,
    onBackButtonClick: () -> Unit,
    scrollBehavior: TopAppBarScrollBehavior? = null,
) {
    CenterAlignedTopAppBar(
        title = title,
        navigationIcon = {
            IconButton(
                onClick = onBackButtonClick
            ) {
                Icon(
                    imageVector = ImageVector.vectorResource(id = R.drawable.ic_arrow_back),
                    contentDescription = "뒤로 가기 버튼",
                )
            }
        },
        scrollBehavior = scrollBehavior,
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CazaitBackTopBar(
    @StringRes title: Int,
    onBackButtonClick: () -> Unit,
    scrollBehavior: TopAppBarScrollBehavior? = null,
) {
    CenterAlignedTopAppBar(
        title = {
            Text(
                text = stringResource(id = title),
                style = CazaitTheme.typography.titleLargeB
            )
        },
        navigationIcon = {
            IconButton(
                onClick = onBackButtonClick,
            ) {
                Icon(
                    imageVector = ImageVector.vectorResource(id = R.drawable.ic_arrow_back),
                    contentDescription = "뒤로 가기 버튼",
                )
            }
        },
        scrollBehavior = scrollBehavior,
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES)
@Preview(uiMode = Configuration.UI_MODE_NIGHT_NO)
@Composable
private fun PreviewCazaitBackTopBar() {
    CazaitTheme {
        CazaitBackTopBar(
            title = { Text(text = "리뷰 쓰기", style = CazaitTheme.typography.titleLargeB) },
            onBackButtonClick = {},
        )
    }
}