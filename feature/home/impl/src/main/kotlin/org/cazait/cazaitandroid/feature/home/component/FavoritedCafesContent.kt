package org.cazait.cazaitandroid.feature.home.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.dp
import org.cazait.cazaitandroid.core.designsystem.theme.CazaitTheme
import org.cazait.cazaitandroid.core.designsystem.theme.SunsetOrange
import org.cazait.cazaitandroid.core.repo.home.api.model.Cafe
import org.cazait.cazaitandroid.feature.home.HomeAllCafesUiState
import org.cazait.cazaitandroid.feature.home.R

@Composable
internal fun FavoritedCafesContent(
    uiState: HomeAllCafesUiState,
    onClickCafe: (Cafe) -> Unit,
) {
    Column(
        modifier = Modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(12.dp),
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp)
                .padding(bottom = 12.dp),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Text(
                text = "찜한매장",
                style = CazaitTheme.typography.titleLargeBL,
            )
            Spacer(modifier = Modifier.width(8.dp))
            Text(text = "찜한 매장을 빠르게 확인!", color = MaterialTheme.colorScheme.primary)
            Spacer(Modifier.weight(1f))
            Icon(
                imageVector = ImageVector.vectorResource(R.drawable.ic_add),
                contentDescription = "자세히",
                tint = MaterialTheme.colorScheme.primary,
            )
        }
        LazyRow(
            horizontalArrangement = Arrangement.spacedBy(8.dp),
        ) {
            // 임시적으로 Surface 50개를 배치했음
            items(count = 50) {
                Surface(
                    modifier = Modifier.size(height = 180.dp, width = 128.dp),
                    color = SunsetOrange,
                ) {}
            }
        }
    }
}
