package org.cazait.cazaitandroid.feature.recentlyview

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import kotlinx.collections.immutable.toImmutableList
import org.cazait.cazaitandroid.core.designsystem.component.CazaitBackTopBar
import org.cazait.cazaitandroid.core.designsystem.theme.Black

@OptIn(ExperimentalMaterial3Api::class)
@Composable
internal fun RecentlyViewedCafeScreen(
    onCafeClick: (cafeId: String) -> Unit,
    onBackButtonClick: () -> Unit,
    viewModel: RecentlyViewedCafeViewModel = hiltViewModel(),
) {
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()
    val cafes = uiState.asList().toImmutableList()
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
            modifier = Modifier.padding(contentPadding).fillMaxSize().padding(horizontal = 20.dp),
        ) {
            items(cafes) {
                Box(modifier = Modifier.size(80.dp).background(color = Black))
            }
        }
    }
}
