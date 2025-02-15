package com.apui.androiddevicemonitor.ui.screens.battery

import android.util.Log
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.apui.androiddevicemonitor.ui.viewModel.BatteryInfoViewModel
import com.apui.androiddevicemonitor.ui.viewModel.TopBarViewModel
import com.apui.androiddevicemonitor.utils.Screens
import org.koin.compose.viewmodel.koinViewModel

@Composable
fun BatteryScreen(
    viewModel: TopBarViewModel = koinViewModel(),
    infoViewModel: BatteryInfoViewModel = koinViewModel(),
) {

    val batteryInfo by infoViewModel.batteryInfo.collectAsStateWithLifecycle()
    Log.d("BatteryScreen", "BatteryScreen: $batteryInfo")
    LaunchedEffect(Unit) {
        viewModel.currentTopBar(isBackButtonVisible = true, screen = Screens.BATTERY)
    }
}