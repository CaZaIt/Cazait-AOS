package org.cazait.cazaitandroid.core.designsystem.component

import android.content.res.Configuration
import androidx.compose.foundation.layout.RowScope
import androidx.compose.material3.Button
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import org.cazait.cazaitandroid.core.designsystem.theme.CazaitTheme

@Composable
fun CazaitButton(
    modifier: Modifier = Modifier,
    onClick: () -> Unit = {},
    content: @Composable RowScope.() -> Unit,
) {
    Button(
        modifier = modifier,
        onClick = onClick,
        content = content,
    )
}

@Composable
@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES)
@Preview(uiMode = Configuration.UI_MODE_NIGHT_NO)
private fun PreviewCazaitButton() {
    CazaitTheme {
        CazaitButton {}
    }
}
