package org.cazait.cazaitandroid.feature.home

import android.content.res.Configuration
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import org.cazait.cazaitandroid.core.designsystem.component.HorizontalDotLine
import org.cazait.cazaitandroid.core.designsystem.theme.CazaitTheme
import org.cazait.cazaitandroid.core.repo.home.api.model.Cafe
import org.cazait.cazaitandroid.feature.home.component.AllCafesContent
import org.cazait.cazaitandroid.feature.home.component.FavoritedCafesContent
import org.cazait.cazaitandroid.feature.home.component.HomeTopBar

@Composable
internal fun HomeScreen(
    padding: PaddingValues,
    onClickCafe: (Cafe) -> Unit,
    uiState: HomeAllCafesUiState,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier
            .padding(padding)
            .background(color = MaterialTheme.colorScheme.primaryContainer)
            .fillMaxSize(),
    ) {
        HomeTopBar()
        HomeMainContent(
            uiState = uiState,
            onClickCafe = onClickCafe,
        )
    }
}

@Composable
private fun HomeMainContent(
    uiState: HomeAllCafesUiState,
    onClickCafe: (Cafe) -> Unit,
) {
    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.spacedBy(12.dp),
    ) {
        item {
            Spacer(Modifier.height(20.dp))
            FavoritedCafesContent(
                uiState = uiState,
                onClickCafe = onClickCafe,
            )
        }

        item { HorizontalDotLine(color = MaterialTheme.colorScheme.primary) }

        item {
            AllCafesContent(
                uiState = uiState,
                onClickCafe = onClickCafe,
            )
            Spacer(Modifier.height(20.dp))
        }
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
            uiState = HomeAllCafesUiState.Loading,
        )
    }
}
