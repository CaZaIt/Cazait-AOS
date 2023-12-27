package org.cazait.cazaitandroid.feature.signin

import org.cazait.cazaitandroid.core.repo.signin.api.model.AccessToken
import org.cazait.cazaitandroid.core.repo.signin.api.model.AccountName
import org.cazait.cazaitandroid.core.repo.signin.api.model.RefreshToken
import org.cazait.cazaitandroid.core.repo.signin.api.model.UserId

internal sealed interface SignInUiState {
    val accountNameInput: String
    val password: String

    data class None(
        override val accountNameInput: String = "",
        override val password: String = "",
    ) : SignInUiState

    data class Loading(
        override val accountNameInput: String,
        override val password: String,
    ) : SignInUiState

    data class Failed(
        override val accountNameInput: String,
        override val password: String,
    ) : SignInUiState

    data class Success(
        val userId: UserId,
        val accountName: AccountName,
        val accessToken: AccessToken,
        val refreshToken: RefreshToken,
    ) : SignInUiState {
        override val accountNameInput: String = ""
        override val password: String = ""
    }
}
