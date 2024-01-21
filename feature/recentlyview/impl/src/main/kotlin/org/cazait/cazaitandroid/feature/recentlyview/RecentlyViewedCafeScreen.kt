package org.cazait.cazaitandroid.feature.recentlyview

import android.content.res.Configuration
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import kotlinx.collections.immutable.ImmutableList
import kotlinx.collections.immutable.persistentListOf
import org.cazait.cazaitandroid.core.designsystem.component.CazaitBackTopBar
import org.cazait.cazaitandroid.core.designsystem.theme.CazaitTheme
import org.cazait.cazaitandroid.core.repo.recentlyview.api.model.RecentlyViewedCafe

@OptIn(ExperimentalMaterial3Api::class)
@Composable
internal fun RecentlyViewedCafeScreen(
    cafes: ImmutableList<RecentlyViewedCafe>,
    onCafeClick: (cafeId: String) -> Unit,
    onBackButtonClick: () -> Unit,
) {
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {
            CazaitBackTopBar(
                title = R.string.recently_viewed_cafe_title,
                onBackButtonClick = onBackButtonClick,
            )
        },
    ) { contentPadding ->
        LazyColumn(
            modifier = Modifier
                .padding(contentPadding)
                .fillMaxSize()
                .padding(horizontal = 20.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp),
        ) {
            item { Spacer(modifier = Modifier.height(12.dp)) }
            items(cafes, key = { cafe ->
                cafe.id.asUUID().toString()
            }) { cafe ->
                RecentlyViewedCafeCard(
                    cafe = cafe,
                    onClick = { onCafeClick(cafe.id.asUUID().toString()) },
                    modifier = Modifier.defaultMinSize(minHeight = 180.dp),
                )
            }
        }
    }
}

@Composable
@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES)
@Preview(uiMode = Configuration.UI_MODE_NIGHT_NO)
private fun RecentlyViewedCafeScreenPreview() {
    CazaitTheme {
        RecentlyViewedCafeScreen(
            cafes = persistentListOf(),
            {},
            {},
        )
    }
}
