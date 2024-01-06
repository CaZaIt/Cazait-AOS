package org.cazait.cazaitandroid.feature.home

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import kotlinx.coroutines.flow.collectLatest

@Composable
internal fun HomeRoute(
    padding: PaddingValues,
    onShowErrorSnackbar: (throwable: Throwable?) -> Unit,
    homeViewModel: HomeViewModel = hiltViewModel(),
) {
    val uiState by homeViewModel.uiState.collectAsStateWithLifecycle()

    LaunchedEffect(true) {
        homeViewModel.errorFlow.collectLatest { throwable -> onShowErrorSnackbar(throwable) }
    }

    HomeScreen(
        padding = padding,
        onClickCafe = {},
        uiState = uiState,
    )
}
