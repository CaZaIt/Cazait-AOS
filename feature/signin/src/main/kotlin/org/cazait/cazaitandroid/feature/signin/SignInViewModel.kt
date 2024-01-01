package org.cazait.cazaitandroid.feature.signin

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import org.cazait.cazaitandroid.core.repo.signin.api.model.AccountName
import org.cazait.cazaitandroid.core.repo.signin.api.model.Password
import org.cazait.cazaitandroid.core.repo.signin.api.model.StoredUser
import org.cazait.cazaitandroid.core.repo.signin.api.model.UserInformation
import org.cazait.cazaitandroid.feature.signin.usecase.PostSignInUseCase
import org.cazait.cazaitandroid.feature.signin.usecase.UpdateUserInformationToLocalUseCase
import javax.inject.Inject

@HiltViewModel
internal class SignInViewModel @Inject constructor(
    private val postSignInUseCase: PostSignInUseCase,
    private val updateUserInformationToLocalUseCase: UpdateUserInformationToLocalUseCase,
) : ViewModel() {
    private val _errorFlow = MutableSharedFlow<Throwable>()
    val errorFlow = _errorFlow.asSharedFlow()

    private val _signInUiState = MutableStateFlow<SignInUiState>(SignInUiState.None())
    val signInUiState = _signInUiState.asStateFlow()

    fun inputAccountName(accountName: String) {
        val state = _signInUiState.value
        if (state !is SignInUiState.None) return

        _signInUiState.update { state.copy(accountNameInput = accountName) }
    }

    fun inputPassword(password: String) {
        val state = _signInUiState.value
        if (state !is SignInUiState.None) return

        _signInUiState.update { state.copy(password = password) }
    }

    fun signIn() {
        val state = _signInUiState.value
        if (state !is SignInUiState.None) return

        viewModelScope.launch {
            flow {
                emit(
                    postSignInUseCase(
                        AccountName(state.accountNameInput),
                        Password(state.password),
                    ),
                )
            }
                .map(SignInUiState::Success)
                .catch { throwable ->
                    throwable.printStackTrace()
                    _errorFlow.emit(throwable)
                }.collect { success ->
                    saveUserInformation(success.userInformation)
                    _signInUiState.update { success }
                }
        }
    }

    private fun saveUserInformation(userInformation: UserInformation) {
        val storedUser = StoredUser(
            userInformation.userId,
            userInformation.accountName,
            userInformation.accessToken,
            userInformation.refreshToken,
        )
        viewModelScope.launch {
            updateUserInformationToLocalUseCase(storedUser)
        }
    }
}
