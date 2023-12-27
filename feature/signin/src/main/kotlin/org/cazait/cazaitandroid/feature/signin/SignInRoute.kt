package org.cazait.cazaitandroid.feature.signin

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import kotlinx.coroutines.flow.collectLatest

@Composable
internal fun SignInRoute(
    onShowErrorSnackBar: (throwable: Throwable) -> Unit,
    signInViewModel: SignInViewModel = hiltViewModel(),
) {
    val signInUiState by signInViewModel.signInUiState.collectAsStateWithLifecycle()

    LaunchedEffect(true) {
        signInViewModel.errorFlow.collectLatest { throwable -> onShowErrorSnackBar(throwable) }
    }

    SignInScreen(
        accountName = signInUiState.accountNameInput,
        password = signInUiState.password,
        onAccountNameChange = signInViewModel::updateAccountName,
        onPasswordChange = signInViewModel::updatePassword,
        onClickSignIn = signInViewModel::signIn,
        onClickSignUp = {},
    )
}
