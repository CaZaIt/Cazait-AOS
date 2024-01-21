package org.cazait.cazaitandroid.feature.mypage

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import org.cazait.cazaitandroid.core.repo.signin.api.usecase.GetStoredUserInformationUseCase
import org.cazait.cazaitandroid.feature.mypage.usecase.SignOutUseCase
import javax.inject.Inject

@HiltViewModel
class MyPageViewModel @Inject constructor(
    private val getStoredUserInformationUseCase: GetStoredUserInformationUseCase,
    private val signOutUseCase: SignOutUseCase,
) : ViewModel() {
    private val _uiState = MutableStateFlow(MyPageUiState(storedUser = null))
    val uiState = _uiState.asStateFlow()

    init {
        viewModelScope.launch {
            getStoredUserInformationUseCase().collect { storedUser ->
                _uiState.update { it.copy(storedUser = storedUser) }
            }
        }
    }

    fun signOut() {
        viewModelScope.launch {
            signOutUseCase()
        }
    }
}
