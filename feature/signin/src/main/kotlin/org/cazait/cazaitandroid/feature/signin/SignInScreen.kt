package org.cazait.cazaitandroid.feature.signin

import android.content.res.Configuration
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import org.cazait.cazaitandroid.core.designsystem.theme.CazaitTheme
import org.cazait.cazaitandroid.feature.session.R
import org.cazait.cazaitandroid.feature.signin.component.SignInTextField

@Composable
internal fun SignInScreen(
    accountName: String,
    password: String,
    onAccountNameChange: (String) -> Unit,
    onPasswordChange: (String) -> Unit,
    onClickSignIn: () -> Unit,
    onClickSignUp: () -> Unit,
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
            .padding(horizontal = 36.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Spacer(modifier = Modifier.height(168.dp))
        Image(
            imageVector = ImageVector.vectorResource(id = org.cazait.cazaitandroid.core.ui.R.drawable.logo_cazait_main),
            contentDescription = "Logo",
            modifier = Modifier.size(144.dp),
        )
        Spacer(modifier = Modifier.height(74.dp))
        Text(
            modifier = Modifier
                .padding(start = 16.dp)
                .align(Alignment.Start),
            text = "LOGIN",
            style = CazaitTheme.typography.bodyLargeR,
        )
        Spacer(modifier = Modifier.height(8.dp))
        SignInTextField(
            modifier = Modifier.fillMaxWidth(),
            value = accountName,
            placeholder = { Text(text = "Username") },
            onValueChange = onAccountNameChange,
        )
        Spacer(modifier = Modifier.height(6.dp))
        SignInTextField(
            modifier = Modifier.fillMaxWidth(),
            value = password,
            placeholder = { Text(text = "Password") },
            onValueChange = onPasswordChange,
            visualTransformation = PasswordVisualTransformation(),
        )
        Spacer(modifier = Modifier.height(27.dp))
        Button(
            modifier = Modifier
                .fillMaxWidth(),
            onClick = onClickSignIn,
        ) {
            Text(
                modifier = Modifier.padding(vertical = 8.dp),
                text = stringResource(id = R.string.do_login),
                style = CazaitTheme.typography.titleMediumB,
            )
        }
        Spacer(modifier = Modifier.height(9.dp))
        Text(
            modifier = Modifier.clickable { onClickSignUp() },
            text = stringResource(id = R.string.do_sign_up),
        )
    }
}

@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES)
@Preview(uiMode = Configuration.UI_MODE_NIGHT_NO)
@Composable
private fun PreviewSignInScreen() {
    CazaitTheme {
        SignInScreen(
            accountName = "",
            password = "",
            onAccountNameChange = {},
            onPasswordChange = {},
            onClickSignIn = {},
            onClickSignUp = {},
        )
    }
}
