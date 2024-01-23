package org.cazait.cazaitandroid.feature.home.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.key
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.dp
import kotlinx.collections.immutable.toImmutableList
import org.cazait.cazaitandroid.core.designsystem.theme.CazaitTheme
import org.cazait.cazaitandroid.core.repo.home.api.model.Cafe
import org.cazait.cazaitandroid.feature.home.HomeAllCafesUiState
import org.cazait.cazaitandroid.feature.home.R

@Composable
internal fun AllCafesContent(
    uiState: HomeAllCafesUiState,
    onClickCafe: (Cafe) -> Unit,
) {
    Column(
        modifier = Modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(12.dp),
    ) {
        Header()
        if (uiState is HomeAllCafesUiState.Success) {
            Contents(uiState, onClickCafe)
        }
    }
}

@Composable
private fun Header() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 20.dp),
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
private fun Contents(
    uiState: HomeAllCafesUiState.Success,
    onClickCafe: (Cafe) -> Unit
) {
    val cafes = uiState.congestionCafes.asList()
    val chunks = cafes.chunked(2).toImmutableList()
    chunks.forEach { chunk ->
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp),
            horizontalArrangement = Arrangement.spacedBy(12.dp),
        ) {
            chunk.forEach { congestionCafe ->
                key(congestionCafe.cafe.id.asUUID().toString()) {
                    HomeCongestionCafeItem(
                        congestionCafe = congestionCafe,
                        onClick = { onClickCafe(congestionCafe.cafe) },
                        modifier = Modifier.weight(1f),
                    )
                }
            }
            if (chunk.size == 1) {
                Spacer(Modifier.weight(1f))
            }
        }
    }
}
