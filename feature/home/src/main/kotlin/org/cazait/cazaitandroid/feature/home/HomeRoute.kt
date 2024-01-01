package org.cazait.cazaitandroid.feature.home

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.hilt.navigation.compose.hiltViewModel
import kotlinx.coroutines.flow.collectLatest

@Composable
internal fun HomeRoute(
    padding: PaddingValues,
    onShowErrorSnackbar: (throwable: Throwable?) -> Unit,
    homeViewModel: HomeViewModel = hiltViewModel(),
) {
    LaunchedEffect(true) {
        homeViewModel.errorFlow.collectLatest { throwable -> onShowErrorSnackbar(throwable) }
    }
    HomeScreen(
        padding = padding,
        onClickCafe = {},
    )
}
