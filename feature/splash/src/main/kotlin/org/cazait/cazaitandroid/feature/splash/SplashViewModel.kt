package org.cazait.cazaitandroid.feature.splash

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class SplashViewModel @Inject constructor() : ViewModel() {

    private val _stateFlow: MutableStateFlow<SplashState> = MutableStateFlow(SplashState())

    val stateFlow: StateFlow<SplashState> = _stateFlow.asStateFlow()
}
