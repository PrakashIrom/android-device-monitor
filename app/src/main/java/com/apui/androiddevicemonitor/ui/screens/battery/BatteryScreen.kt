package com.apui.androiddevicemonitor.ui.screens.battery

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.navigation.NavHostController
import com.apui.androiddevicemonitor.ui.viewModel.TopBarViewModel
import com.apui.androiddevicemonitor.utils.Screens
import org.koin.compose.viewmodel.koinViewModel

@Composable
fun BatteryScreen(navController: NavHostController, viewModel: TopBarViewModel = koinViewModel()) {

    LaunchedEffect(Unit) {
        viewModel.currentTopBar(isBackButtonVisible = true, screen = Screens.BATTERY)
    }

}