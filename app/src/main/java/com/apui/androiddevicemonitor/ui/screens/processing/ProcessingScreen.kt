package com.apui.androiddevicemonitor.ui.screens.processing

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import com.apui.androiddevicemonitor.ui.viewModel.TopBarViewModel
import com.apui.androiddevicemonitor.utils.Screens
import org.koin.compose.viewmodel.koinViewModel

@Composable
fun ProcessingScreen(viewModel: TopBarViewModel = koinViewModel()){
    LaunchedEffect(Unit) {
        viewModel.currentTopBar(isBackButtonVisible = true, screen = Screens.PROCESSING)

    }
}