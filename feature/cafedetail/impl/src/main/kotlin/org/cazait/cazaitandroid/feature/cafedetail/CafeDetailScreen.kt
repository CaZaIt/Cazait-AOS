package org.cazait.cazaitandroid.feature.cafedetail

import android.content.res.Configuration
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.PathEffect
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import me.onebone.toolbar.CollapsingToolbarScaffold
import me.onebone.toolbar.ScrollStrategy
import me.onebone.toolbar.rememberCollapsingToolbarScaffoldState
import org.cazait.cazaitandroid.core.designsystem.theme.CazaitTheme
import org.cazait.cazaitandroid.core.designsystem.theme.SunsetOrange

@Composable
internal fun CafeDetailScreen(
    uiState: CafeDetailUiState,
    onClickTab: () -> Unit,
) {
    if (uiState.menuUiState is CafeDetailMenuUiState.Success) {
        Text(text = uiState.menuUiState.cafeMenus.toString())
    }
    CafeDetailScreen()
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
private fun CafeDetailScreen() {
    val collapsingToolbarScaffoldState = rememberCollapsingToolbarScaffoldState()
    val pagerState = rememberPagerState {
        1
    }

    CollapsingToolbarScaffold(modifier = Modifier.fillMaxSize(),
        state = collapsingToolbarScaffoldState,
        scrollStrategy = ScrollStrategy.ExitUntilCollapsed,
        toolbar = {
            Image(
                imageVector = ImageVector.vectorResource(org.cazait.cazaitandroid.core.ui.R.drawable.logo_cazait_main),
                contentDescription = null,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(300.dp),
            )
            Surface(
                modifier = Modifier
                    .height(88.dp)
                    .fillMaxWidth()
                    .road(
                        whenCollapsed = Alignment.BottomCenter,
                        whenExpanded = Alignment.BottomCenter,
                    ),
                shape = RoundedCornerShape(topStart = 40.dp, topEnd = 40.dp),
                color = MaterialTheme.colorScheme.primaryContainer
            ) {
                ConstraintLayout {
                    Column(
                        verticalArrangement = Arrangement.spacedBy(4.dp)
                    ) {
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(horizontal = 28.dp)
                                .padding(top = 20.dp),
                            horizontalArrangement = Arrangement.SpaceBetween,
                        ) {
                            Text(
                                text = "팬도로시",
                                modifier = Modifier.padding(end = 12.dp),
                                style = CazaitTheme.typography.titleLargeBL
                            )

                            Text(
                                text = "매장 위치 확인 >",
                                modifier = Modifier.align(Alignment.Bottom),
                                style = CazaitTheme.typography.bodySmallR,
                                color = MaterialTheme.colorScheme.primary
                            )

                            Spacer(modifier = Modifier.weight(1f))
                            Image(
                                imageVector = ImageVector.vectorResource(id = R.drawable.ic_heart_empty),
                                contentDescription = "찜하기 버튼",
                                modifier = Modifier
                                    .size(26.dp)
                                    .align(Alignment.CenterVertically)
                            )
                        }
                        Text(
                            text = "주소주소주소",
                            modifier = Modifier.padding(start = 28.dp),
                            style = CazaitTheme.typography.bodySmallR,
                        )
                    }
                }
                Canvas(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(horizontal = 28.dp)
                ) {
                    val canvasWidth = size.width
                    val yPosition = size.height
                    val pathEffect = PathEffect.dashPathEffect(floatArrayOf(30f, 15f), 0f)

                    drawLine(
                        color = SunsetOrange,
                        start = Offset(0f, yPosition),
                        end = Offset(canvasWidth, yPosition),
                        pathEffect = pathEffect,
                        strokeWidth = 1.dp.toPx()
                    )
                }
            }
        }) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(color = MaterialTheme.colorScheme.primaryContainer)
                .padding(horizontal = 28.dp)
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 40.dp, vertical = 16.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = "카페 메뉴",
                    style = CazaitTheme.typography.titleMediumB
                )
                Text(
                    text = "평점 및 후기",
                    style = CazaitTheme.typography.titleMediumB
                )
            }
            HorizontalPager(
                state = pagerState
            ) {
                LazyColumn(
                    modifier = Modifier.weight(1f),
                    verticalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    items(100) {
                        Text(text = "tttttt")
                    }
                }
                when (it) {
                    1 -> {

                    }
                }
            }
        }
    }
}

@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES)
@Preview(uiMode = Configuration.UI_MODE_NIGHT_NO)
@Composable
private fun PreviewTest() {
    CazaitTheme {
        CafeDetailScreen()
    }
}
