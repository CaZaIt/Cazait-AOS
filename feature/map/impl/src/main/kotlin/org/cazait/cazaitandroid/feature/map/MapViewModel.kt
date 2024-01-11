package org.cazait.cazaitandroid.feature.map

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
import org.cazait.cazaitandroid.core.location.LocationDetails
import org.cazait.cazaitandroid.core.location.usecase.GetLocationUseCase
import org.cazait.cazaitandroid.core.repo.home.api.model.DistanceLimit
import org.cazait.cazaitandroid.core.repo.home.api.model.Latitude
import org.cazait.cazaitandroid.core.repo.home.api.model.Longitude
import org.cazait.cazaitandroid.core.repo.home.api.model.SortBy
import org.cazait.cazaitandroid.feature.map.usecase.GetCongestionCafesUseCase
import javax.inject.Inject

@HiltViewModel
internal class MapViewModel @Inject constructor(
    private val getLocationUseCase: GetLocationUseCase,
    private val getCongestionCafesUseCase: GetCongestionCafesUseCase,
) : ViewModel() {
    private val _errorFlow = MutableSharedFlow<Throwable>()
    val errorFlow = _errorFlow.asSharedFlow()

    private val _currentLocation = MutableStateFlow(LocationDetails(37.532600, 127.024612))
    val currentLocation = _currentLocation.asStateFlow()

    private val _uiState: MutableStateFlow<MapUiState> = MutableStateFlow(MapUiState.Loading)
    val uiState = _uiState.asStateFlow()

    fun fetchCongestionCafes(
        sortBy: SortBy = SortBy.DISTANCE,
        limit: DistanceLimit = DistanceLimit(2000),
    ) {
        _uiState.update { MapUiState.Loading }

        viewModelScope.launch {
            flow {
                emit(
                    getCongestionCafesUseCase(
                        latitude = Latitude(_currentLocation.value.latitude),
                        longitude = Longitude(_currentLocation.value.longitude),
                        sortBy = sortBy,
                        limit = limit,
                    )
                )
            }
                .map(MapUiState::Success)
                .catch {
                    it.printStackTrace()
                    _errorFlow.emit(it)
                }
                .collect { success ->
                    _uiState.update { success }
                }
        }
    }

    fun handlePermission(event: PermissionEvent) {
        when (event) {
            PermissionEvent.Granted -> {
                viewModelScope.launch {
                    var isFirstLocationCollected = false
                    getLocationUseCase().collect { location ->
                        _currentLocation.update { location ?: LocationDetails(37.0, 126.0) }
                        if (!isFirstLocationCollected) {
                            fetchCongestionCafes()
                            isFirstLocationCollected = true
                        }
                    }
                }
            }

            PermissionEvent.Revoked -> {
                _uiState.update { MapUiState.RevokedPermissions }
            }
        }
    }
}