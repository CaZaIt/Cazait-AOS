package org.cazait.cazaitandroid.feature.home

import android.content.res.Configuration
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import kotlinx.collections.immutable.toImmutableList
import org.cazait.cazaitandroid.core.designsystem.theme.Black
import org.cazait.cazaitandroid.core.designsystem.theme.CazaitTheme
import org.cazait.cazaitandroid.core.designsystem.theme.White
import org.cazait.cazaitandroid.core.repo.home.api.model.Cafe
import org.cazait.cazaitandroid.core.repo.home.api.model.CongestionCafe
import org.cazait.cazaitandroid.feature.home.component.HomeCongestionCafeItem

@Composable
internal fun HomeScreen(
    padding: PaddingValues,
    onClickCafe: (Cafe) -> Unit,
    uiState: HomeUiState,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier
            .padding(padding)
            .background(color = MaterialTheme.colorScheme.primaryContainer)
            .fillMaxSize(),
    ) {
        HomeTopBar()
        HomeContent(
            uiState = uiState,
            onClickCafe = onClickCafe,
        )
    }
}

@Composable
private fun HomeTopBar() {
    Surface(
        modifier = Modifier.fillMaxWidth(),
        color = MaterialTheme.colorScheme.background,
        shape = RoundedCornerShape(bottomStart = 40.dp, bottomEnd = 40.dp),
    ) {
        Row(
            modifier = Modifier.padding(28.dp),
            horizontalArrangement = Arrangement.spacedBy(12.dp),
        ) {
            Icon(
                imageVector = ImageVector.vectorResource(id = R.drawable.ic_it),
                contentDescription = "Cazait Icon",
                modifier = Modifier
                    .size(40.dp)
                    .align(Alignment.CenterVertically),
            )
            SearchingTextField(modifier = Modifier.weight(1f))
            Icon(
                imageVector = ImageVector.vectorResource(id = R.drawable.ic_alarm_normal),
                contentDescription = "Notification",
                modifier = Modifier
                    .size(40.dp)
                    .align(Alignment.CenterVertically),
            )
        }
    }
}

@Composable
private fun HomeContent(
    uiState: HomeUiState,
    onClickCafe: (Cafe) -> Unit,
) {
    LazyColumn(
        modifier = Modifier.fillMaxSize(),
    ) {
        item {
            Spacer(modifier = Modifier.height(12.dp))
            HomeColumnTitle()
        }

        if (uiState is HomeUiState.Success) {
            val cafes = uiState.congestionCafes.asList()
            val chunks = cafes.chunked(2).toImmutableList()
            items(chunks, key = { it.first().cafe.id.asUUID().toString() }) { chunk ->
                CafeRow(chunk = chunk, onClickCafe = onClickCafe)
            }
        }
    }
}

@Composable
private fun CafeRow(
    chunk: List<CongestionCafe>,
    onClickCafe: (Cafe) -> Unit,
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 20.dp)
            .padding(bottom = 32.dp),
        horizontalArrangement = Arrangement.spacedBy(12.dp),
    ) {
        chunk.forEach { congestionCafe ->
            HomeCongestionCafeItem(
                congestionCafe = congestionCafe,
                onClick = { onClickCafe(congestionCafe.cafe) },
                modifier = Modifier.weight(1f),
            )
        }
        if (chunk.size == 1) {
            Spacer(modifier = Modifier.weight(1f))
        }
    }
}

@Composable
private fun SearchingTextField(
    modifier: Modifier = Modifier,
) {
    Surface(
        modifier = modifier,
        color = Black,
        shadowElevation = 10.dp,
        shape = RoundedCornerShape(48.dp),
    ) {
        TextField(
            shape = RoundedCornerShape(48.dp),
            value = "",
            onValueChange = {},
            placeholder = {
                Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                    Icon(
                        imageVector = ImageVector.vectorResource(R.drawable.ic_search),
                        contentDescription = "Search Icon",
                        tint = White,
                    )
                    Text(
                        text = stringResource(id = R.string.search),
                        color = MaterialTheme.colorScheme.onSurface,
                    )
                }
            },
            colors = TextFieldDefaults.colors(
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent,
                disabledIndicatorColor = Color.Transparent,
                unfocusedContainerColor = Color.Transparent,
                focusedContainerColor = Color.Transparent,
            ),
        )
    }
}

@Composable
private fun HomeColumnTitle() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 20.dp)
            .padding(bottom = 12.dp),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Text(
            text = stringResource(id = R.string.home_cafes_column_title),
            style = CazaitTheme.typography.titleLargeBL,
        )
        Spacer(modifier = Modifier.weight(1f))
        Image(
            imageVector = ImageVector.vectorResource(R.drawable.ic_filter),
            contentDescription = "filter",
        )
        Spacer(modifier = Modifier.width(8.dp))
        Text(
            text = stringResource(id = R.string.distance),
            style = CazaitTheme.typography.titleMediumB,
        )
    }
}

@Composable
@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES)
@Preview(uiMode = Configuration.UI_MODE_NIGHT_NO)
private fun HomeScreenPreview() {
    CazaitTheme {
        HomeScreen(
            padding = PaddingValues(0.dp),
            onClickCafe = {},
            uiState = HomeUiState.Loading,
        )
    }
}
