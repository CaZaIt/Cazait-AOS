package org.cazait.cazaitandroid.feature.cafedetail

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
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
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import kotlinx.collections.immutable.toImmutableList
import me.onebone.toolbar.CollapsingToolbarScaffold
import me.onebone.toolbar.CollapsingToolbarScope
import me.onebone.toolbar.ScrollStrategy
import me.onebone.toolbar.rememberCollapsingToolbarScaffoldState
import org.cazait.cazaitandroid.core.designsystem.component.NetworkImage
import org.cazait.cazaitandroid.core.designsystem.theme.Black
import org.cazait.cazaitandroid.core.designsystem.theme.CazaitTheme
import org.cazait.cazaitandroid.core.designsystem.theme.SunsetOrange
import org.cazait.cazaitandroid.core.repo.cafedetail.api.model.CafeAddress
import org.cazait.cazaitandroid.core.repo.cafedetail.api.model.CafeImage
import org.cazait.cazaitandroid.core.repo.cafedetail.api.model.CafeImages
import org.cazait.cazaitandroid.core.repo.cafedetail.api.model.CafeMenus
import org.cazait.cazaitandroid.core.repo.cafedetail.api.model.CafeName

@Composable
internal fun CafeDetailScreen(
    detailUiState: CafeDetailUiState,
) {
    Box(modifier = Modifier.fillMaxSize()) {
        when (detailUiState) {
            is CafeDetailUiState.Loading -> {
                LoadingContent()
            }

            is CafeDetailUiState.Success -> {
                MenuReviewContent(detailUiState)
            }
        }
    }
}

@Composable
internal fun LoadingContent() {
    Box(modifier = Modifier.fillMaxSize())
}

@Composable
private fun MenuReviewContent(
    detailUiState: CafeDetailUiState.Success,
) {
    val collapsingToolbarScaffoldState = rememberCollapsingToolbarScaffoldState()

    CollapsingToolbarScaffold(
        modifier = Modifier.fillMaxSize(),
        state = collapsingToolbarScaffoldState,
        scrollStrategy = ScrollStrategy.ExitUntilCollapsed,
        toolbar = {
            CafeBackgroundHeader(
                cafeName = detailUiState.cafeDetailInfo.name,
                address = detailUiState.cafeDetailInfo.address,
                cafeImages = detailUiState.cafeDetailInfo.cafeImages,
            )
        }) {
        MenuReviewContent(detailUiState.menus)
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
private fun CollapsingToolbarScope.CafeBackgroundHeader(
    cafeName: CafeName,
    address: CafeAddress,
    cafeImages: CafeImages,
) {
    val cafeImageUrls = cafeImages.asList().map(CafeImage::asString).toImmutableList()
    val cafeImagesPagerState = rememberPagerState { cafeImageUrls.size }

    HorizontalPager(
        modifier = Modifier
            .fillMaxWidth()
            .height(300.dp),
        state = cafeImagesPagerState,
    ) {
        NetworkImage(
            imageUrl = cafeImageUrls[it],
            modifier = Modifier.fillMaxSize(),
        )
    }
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
                        text = cafeName.asString(),
                        modifier = Modifier.padding(end = 12.dp),
                        style = CazaitTheme.typography.titleLargeBL
                    )

                    Text(
                        text = stringResource(R.string.check_store_address_with_map),
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
                    text = address.asString(),
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
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
private fun MenuReviewContent(
    menus: CafeMenus,
) {
    val pagerState = rememberPagerState(initialPage = 0) { 2 }

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
                text = stringResource(R.string.cafe_menu),
                style = CazaitTheme.typography.titleMediumB,
                color = if (pagerState.currentPage == 0) SunsetOrange else Black
            )
            Text(
                text = stringResource(R.string.score_and_review),
                style = CazaitTheme.typography.titleMediumB,
                color = if (pagerState.currentPage == 1) SunsetOrange else Black
            )
        }
        HorizontalPager(
            state = pagerState
        ) { currentPage ->
            when (currentPage) {
                0 -> LazyColumn(
                    modifier = Modifier.fillMaxSize(),
                    verticalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    items(
                        items = menus.asList(),
                        key = { it.menuId.asInt() }
                    ) { menu ->
                        MenuCard(menu = menu)
                    }
                }

                1 -> {
                    Box(modifier = Modifier.fillMaxSize())
                }
            }
        }
    }
}
