package org.cazait.cazaitandroid.feature.signin

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
internal class SignInViewModel @Inject constructor() : ViewModel() {
    private val _errorFlow = MutableSharedFlow<Throwable>()
    val errorFlow = _errorFlow.asSharedFlow()

    private val _signInUiState = MutableStateFlow<SignInUiState>(SignInUiState.None())
    val signInUiState = _signInUiState.asStateFlow()

    fun updateAccountName(accountName: String) {
        val state = _signInUiState.value
        if (state !is SignInUiState.None) return

        _signInUiState.update { state.copy(accountNameInput = accountName) }
    }

    fun updatePassword(password: String) {
        val state = _signInUiState.value
        if (state !is SignInUiState.None) return

        _signInUiState.update { state.copy(password = password) }
    }

    fun signIn() {
        val state = _signInUiState.value
        if (state !is SignInUiState.None) return
    }
}
