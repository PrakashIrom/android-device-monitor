package com.apui.androiddevicemonitor.ui.screens.battery

import android.app.Application
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.apui.androiddevicemonitor.data.models.BatteryInfo
import com.apui.androiddevicemonitor.ui.viewModel.BatteryInfoViewModel
import com.apui.androiddevicemonitor.ui.viewModel.TopBarViewModel
import com.apui.androiddevicemonitor.utils.Screens
import org.koin.compose.viewmodel.koinViewModel
import org.koin.core.parameter.parametersOf

@Composable
fun BatteryScreen(
    viewModel: TopBarViewModel = koinViewModel(),
) {

    val application = LocalContext.current.applicationContext as Application
    val infoViewModel: BatteryInfoViewModel =
        koinViewModel(parameters = { parametersOf(application) })
    val batteryInfo by infoViewModel.batteryInfo.collectAsStateWithLifecycle()

    LaunchedEffect(Unit) {
        viewModel.currentTopBar(isBackButtonVisible = true, screen = Screens.BATTERY)
    }
    BatteryScreenContent(batteryInfo)
}

@Composable
fun BatteryScreenContent(batteryInfo: BatteryInfo) {

    val batteryDetails = listOf(
        "Health" to batteryInfo.health,
        "Percentage" to "${batteryInfo.percentage}%",
        "Plugged" to batteryInfo.plugged,
        "Status" to batteryInfo.status,
        "Temperature" to "${batteryInfo.temperature}°C",
        "Voltage" to "${batteryInfo.voltage}V"
    )

    Column(
        modifier = Modifier
            .padding(top = 110.dp)
            .fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        batteryDetails.forEach { (label, value) ->
            BatteryInfoItem(label = label, value = value)
        }
    }
}

@Composable
fun BatteryInfoItem(label: String, value: String) {
    Row(
        modifier = Modifier.padding(vertical = 4.dp),
    ) {
        Text(
            text = "$label:",
            fontWeight = FontWeight.Bold,
            //modifier = Modifier.weight(1f),
        )
        Text(text = value, modifier = Modifier.weight(1f))
    }
}