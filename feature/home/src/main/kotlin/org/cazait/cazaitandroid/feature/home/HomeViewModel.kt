package org.cazait.cazaitandroid.feature.home

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
import org.cazait.cazaitandroid.core.repo.home.api.model.DistanceLimit
import org.cazait.cazaitandroid.core.repo.home.api.model.Latitude
import org.cazait.cazaitandroid.core.repo.home.api.model.Longitude
import org.cazait.cazaitandroid.core.repo.home.api.model.SortBy
import org.cazait.cazaitandroid.feature.home.usecase.GetCongestionCafesUseCase
import javax.inject.Inject

@HiltViewModel
internal class HomeViewModel @Inject constructor(
    private val getCongestionCafesUseCase: GetCongestionCafesUseCase,
) : ViewModel() {
    private val _errorFlow = MutableSharedFlow<Throwable>()
    val errorFlow = _errorFlow.asSharedFlow()

    private val _uiState: MutableStateFlow<HomeUiState> = MutableStateFlow(HomeUiState.Loading)
    val uiState = _uiState.asStateFlow()

    fun fetchCongestionCafes(
        latitude: Double,
        longitude: Double,
        sortBy: SortBy = SortBy.DISTANCE,
        limit: DistanceLimit = DistanceLimit(1000),
    ) {
        viewModelScope.launch {
            flow { emit(getCongestionCafesUseCase(
                latitude = Latitude(latitude),
                longitude = Longitude(longitude),
                sortBy = sortBy,
                limit = limit,
            )) }
                .map(HomeUiState::Success)
                .catch {
                    it.printStackTrace()
                    _errorFlow.emit(it)
                }
                .collect { success ->
                    _uiState.update { success }
                }
        }
    }
}