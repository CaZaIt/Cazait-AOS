package org.cazait.cazaitandroid.feature.signin

import org.cazait.cazaitandroid.core.repo.signin.api.model.UserInformation

internal sealed interface SignInUiState {
    val accountNameInput: String
    val password: String

    data class None(
        override val accountNameInput: String = "",
        override val password: String = "",
    ) : SignInUiState

    data class Success(
        val userInformation: UserInformation,
    ) : SignInUiState {
        override val accountNameInput: String = ""
        override val password: String = ""
    }
}
