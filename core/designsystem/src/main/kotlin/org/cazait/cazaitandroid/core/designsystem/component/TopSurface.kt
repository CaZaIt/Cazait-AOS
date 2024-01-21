package org.cazait.cazaitandroid.core.designsystem.component

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun TopSurface(
    content: @Composable () -> Unit,
) {
    Surface(
        modifier = Modifier.fillMaxWidth().height(100.dp),
        color = MaterialTheme.colorScheme.background,
        shape = RoundedCornerShape(bottomStart = 40.dp, bottomEnd = 40.dp),
        content = content,
    )
}