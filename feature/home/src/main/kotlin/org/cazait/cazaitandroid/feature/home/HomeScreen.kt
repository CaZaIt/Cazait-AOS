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
import org.cazait.cazaitandroid.core.designsystem.component.CazaitCard
import org.cazait.cazaitandroid.core.designsystem.theme.Black
import org.cazait.cazaitandroid.core.designsystem.theme.CazaitTheme
import org.cazait.cazaitandroid.core.designsystem.theme.White

@Composable
internal fun HomeScreen(
    padding: PaddingValues,
    onClickCafe: () -> Unit,
    uiState: HomeUiState,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier
            .padding(padding)
            .background(color = MaterialTheme.colorScheme.primaryContainer)
            .fillMaxSize(),
        verticalArrangement = Arrangement.spacedBy(20.dp),
    ) {
        HomeTopBar()
        when (uiState) {
            is HomeUiState.Success -> {
                LazyColumn(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 20.dp)
                ) {
                    item { HomeColumnTitle() }
                    items(uiState.congestionCafes.asList()) {
                        CazaitCard {
                            Text(text = it.cafe.name.asString())
                        }
                    }
                }
            }

            else -> {

            }
        }

    }
}

@Composable
private fun HomeColumnTitle() {
    Row(verticalAlignment = Alignment.CenterVertically) {
        Text(
            text = stringResource(id = R.string.home_cafes_column_title),
            style = CazaitTheme.typography.titleLargeBL
        )
        Spacer(modifier = Modifier.weight(1f))
        Image(
            imageVector = ImageVector.vectorResource(R.drawable.ic_filter),
            contentDescription = "filter",
        )
        Spacer(modifier = Modifier.width(8.dp))
        Text(
            text = stringResource(id = R.string.distance),
            style = CazaitTheme.typography.titleMediumB
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
                        color = MaterialTheme.colorScheme.onSurface
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
