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
import org.cazait.cazaitandroid.core.location.LocationDetails
import org.cazait.cazaitandroid.core.location.usecase.GetLocationUseCase
import org.cazait.cazaitandroid.core.repo.home.api.model.Cafe
import org.cazait.cazaitandroid.core.repo.home.api.model.DistanceLimit
import org.cazait.cazaitandroid.core.repo.home.api.model.Latitude
import org.cazait.cazaitandroid.core.repo.home.api.model.Longitude
import org.cazait.cazaitandroid.core.repo.home.api.model.SortBy
import org.cazait.cazaitandroid.feature.home.usecase.GetCongestionCafesUseCase
import org.cazait.cazaitandroid.feature.home.usecase.StoreViewedCafeUseCase
import javax.inject.Inject

@HiltViewModel
internal class HomeViewModel @Inject constructor(
    private val getLocationUseCase: GetLocationUseCase,
    private val storeViewedCafeUseCase: StoreViewedCafeUseCase,
    private val getCongestionCafesUseCase: GetCongestionCafesUseCase,
) : ViewModel() {
    private val _errorFlow = MutableSharedFlow<Throwable>()
    val errorFlow = _errorFlow.asSharedFlow()

    private val _currentLocation = MutableStateFlow(LocationDetails(37.5538202, 127.0832242))
    val currentLocation = _currentLocation.asStateFlow()

    private val _uiState: MutableStateFlow<HomeUiState> = MutableStateFlow(HomeUiState.Loading)
    val uiState = _uiState.asStateFlow()

    init {
        fetchCongestionCafes()
    }

    fun handlePermission(event: PermissionEvent) {
        when (event) {
            PermissionEvent.Granted -> {
                viewModelScope.launch {
                    var isFirstLocationCollected = false
                    getLocationUseCase().collect { location ->
                        _currentLocation.update {
                            location ?: LocationDetails(
                                37.5538202,
                                127.0832242,
                            )
                        }
                        if (!isFirstLocationCollected) {
                            fetchCongestionCafes()
                            isFirstLocationCollected = true
                        }
                    }
                }
            }

            PermissionEvent.Revoked -> {
                _uiState.update { HomeUiState.RevokedPermissions }
            }
        }
    }

    fun storeViewedCafe(cafe: Cafe) {
        viewModelScope.launch {
            storeViewedCafeUseCase(cafe)
        }
    }

    private fun fetchCongestionCafes(
        sortBy: SortBy = SortBy.DISTANCE,
        limit: DistanceLimit = DistanceLimit(2000),
    ) {
        _uiState.update { HomeUiState.Loading }

        viewModelScope.launch {
            flow {
                emit(
                    getCongestionCafesUseCase(
                        latitude = Latitude(_currentLocation.value.latitude),
                        longitude = Longitude(_currentLocation.value.longitude),
                        sortBy = sortBy,
                        limit = limit,
                    ),
                )
            }
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
