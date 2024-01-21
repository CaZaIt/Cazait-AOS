package org.cazait.cazaitandroid.feature.recentlyview

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import org.cazait.cazaitandroid.core.repo.recentlyview.api.model.RecentlyViewedCafes
import org.cazait.cazaitandroid.feature.recentlyview.usecase.GetAllRecentlyViewedCafeUseCase
import javax.inject.Inject

@HiltViewModel
internal class RecentlyViewedCafeViewModel @Inject constructor(
    private val getAllRecentlyViewedCafeUseCase: GetAllRecentlyViewedCafeUseCase,
) : ViewModel() {
    private val _uiState = MutableStateFlow(RecentlyViewedCafes(emptyList()))
    val uiState = _uiState.asStateFlow()

    init {
        viewModelScope.launch {
            _uiState.value = getAllRecentlyViewedCafeUseCase()
        }
    }
}
