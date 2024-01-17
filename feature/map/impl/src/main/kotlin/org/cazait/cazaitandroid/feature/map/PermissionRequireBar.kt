package org.cazait.cazaitandroid.feature.map

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import org.cazait.cazaitandroid.core.designsystem.theme.CazaitTheme

@Composable
internal fun PermissionRequireBar(
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    Surface(
        modifier = modifier,
        color = MaterialTheme.colorScheme.surface.copy(alpha = 0.7f),
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp, vertical = 16.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Text(
                text = "내 위치 바로가기 버튼을 활성화 하기 위해 권한을 허가해주세요.",
                modifier = Modifier.weight(1f),
                style = CazaitTheme.typography.bodyLargeR,
            )
            Text(
                text = "권한 설정",
                color = Color.Blue,
                modifier = Modifier
                    .clickable { onClick() },
                style = CazaitTheme.typography.titleMediumB,
            )
        }
    }
}
