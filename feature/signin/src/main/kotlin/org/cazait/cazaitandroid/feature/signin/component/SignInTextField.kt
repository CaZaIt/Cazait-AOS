package org.cazait.cazaitandroid.feature.signin.component

import android.content.res.Configuration
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import org.cazait.cazaitandroid.core.designsystem.theme.CazaitTheme

@Composable
internal fun SignInTextField(
    onValueChange: (String) -> Unit,
    modifier: Modifier = Modifier,
    value: String = "",
    visualTransform: VisualTransformation = VisualTransformation.None,
    placeholder: @Composable () -> Unit,
) {
    TextField(
        modifier = modifier,
        value = value,
        onValueChange = onValueChange,
        placeholder = placeholder,
        shape = RoundedCornerShape(50.dp),
        colors = TextFieldDefaults.colors(
            unfocusedTextColor = MaterialTheme.colorScheme.onPrimaryContainer,
            focusedTextColor = MaterialTheme.colorScheme.onPrimaryContainer,
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent,
            disabledIndicatorColor = Color.Transparent,
        ),
        singleLine = true,
        visualTransformation = visualTransform,
    )
}

@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES)
@Preview(uiMode = Configuration.UI_MODE_NIGHT_NO)
@Composable
private fun Preview() {
    CazaitTheme {
        SignInTextField(
            onValueChange = {},
            modifier = Modifier.fillMaxWidth(),
            value = "",
            placeholder = { Text(text = "placeholer") },
        )
    }
}
