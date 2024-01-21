package org.cazait.cazaitandroid.feature.recentlyview

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import org.cazait.cazaitandroid.core.designsystem.component.CazaitTopBar

@OptIn(ExperimentalMaterial3Api::class)
@Composable
internal fun RecentlyViewedCafeScreen(
    onCafeClick: (cafeId: String) -> Unit,
    viewModel: RecentlyViewedCafeViewModel = hiltViewModel(),
) {
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = { CazaitTopBar(title = R.string.recently_viewed_cafe_title) },
    ) { contentPadding ->
        LazyColumn(
            modifier = Modifier.padding(contentPadding).fillMaxSize().padding(horizontal = 20.dp),
        ) {
        }
    }
}
