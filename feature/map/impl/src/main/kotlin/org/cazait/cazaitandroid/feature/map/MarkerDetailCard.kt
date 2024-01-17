package org.cazait.cazaitandroid.feature.map

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import org.cazait.cazaitandroid.core.designsystem.theme.CazaitTheme
import org.cazait.cazaitandroid.core.repo.home.api.model.CongestionCafe
import org.cazait.cazaitandroid.feature.map.mapper.asStringRes

@Composable
internal fun MarkerDetailCard(
    cafe: CongestionCafe,
    onClick: () -> Unit,
) {
    Surface(
        modifier = Modifier
            .size(height = 116.dp, width = 284.dp)
            .clickable { onClick() },
        shape = RoundedCornerShape(12.dp),
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 20.dp, vertical = 12.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp),
        ) {
            Row(
                verticalAlignment = Alignment.Bottom,
                horizontalArrangement = Arrangement.spacedBy(8.dp),
            ) {
                Text(text = cafe.cafe.name.asString(), style = CazaitTheme.typography.titleLargeBL)
                Text(text = "${cafe.distance.asInt()}m", style = CazaitTheme.typography.bodySmallR)
            }
            Text(text = cafe.cafe.address.asString(), style = CazaitTheme.typography.bodyMediumR)
            Surface(
                color = MaterialTheme.colorScheme.primary,
                shape = RoundedCornerShape(100.dp),
                modifier = Modifier.fillMaxWidth(),
            ) {
                Text(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 8.dp),
                    text = stringResource(id = cafe.congestion.asStringRes()),
                    style = CazaitTheme.typography.titleMediumB,
                    textAlign = TextAlign.Center,
                )
            }
        }
    }
}
