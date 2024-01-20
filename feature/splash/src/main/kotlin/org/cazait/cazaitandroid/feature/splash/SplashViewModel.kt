package org.cazait.cazaitandroid.feature.splash

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import org.cazait.cazaitandroid.feature.splash.usecase.GetStoredUserInformationUseCase
import javax.inject.Inject

@HiltViewModel
internal class SplashViewModel @Inject constructor(
    private val getStoredUserInformationUseCase: GetStoredUserInformationUseCase,
) : ViewModel() {
    private val _uiState: MutableStateFlow<SplashUiState> =
        MutableStateFlow(SplashUiState.NotStored)
    val uiState = _uiState.asStateFlow()

    init {
        viewModelScope.launch {
            getStoredUserInformationUseCase().collect { storedUser ->
                _uiState.update { if (storedUser != null) SplashUiState.Stored else SplashUiState.NotStored }
            }
        }
    }
}
