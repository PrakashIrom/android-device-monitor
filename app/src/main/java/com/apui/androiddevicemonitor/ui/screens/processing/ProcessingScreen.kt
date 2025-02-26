package com.apui.androiddevicemonitor.ui.screens.processing

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.State
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.apui.androiddevicemonitor.data.models.RunningServices
import com.apui.androiddevicemonitor.domain.model.RamUsageInfo
import com.apui.androiddevicemonitor.ui.viewModel.RamInfoViewModel
import com.apui.androiddevicemonitor.ui.viewModel.RunningServicesViewModel
import com.apui.androiddevicemonitor.ui.viewModel.TopBarViewModel
import com.apui.androiddevicemonitor.utils.Screens
import org.koin.compose.viewmodel.koinViewModel

@Composable
fun ProcessingScreen(
    viewModel: TopBarViewModel = koinViewModel(),
    ramInfoViewModel: RamInfoViewModel = koinViewModel(),
    runningServicesViewModel: RunningServicesViewModel = koinViewModel(),
) {
    LaunchedEffect(Unit) {
        viewModel.currentTopBar(isBackButtonVisible = true, screen = Screens.PROCESSING)
    }
    ProcessingScreenContents(
        ramInfoViewModel.ramUsageInfo,
        runningServicesViewModel.runningServices,
    )
}

@Composable
fun ProcessingScreenContents(
    ramUsageInfo: State<RamUsageInfo>,
    runningServices: SnapshotStateList<RunningServices>,
) {
    Column(
        modifier =
            Modifier
                .padding(top = 110.dp)
                .fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Text("Total memory: ${ramUsageInfo.value.totalMemory}")
        Text("Available memory: ${ramUsageInfo.value.availableMemory}")
        Text("Used memory: ${ramUsageInfo.value.usedMemory}")
        LazyColumn {
            items(runningServices.size) { runningService ->
                Text("Process name: ${runningServices[runningService].processName}")
                Text("Importance: ${runningServices[runningService].importance}")
                Text("Process Id: ${runningServices[runningService].pid}")
            }
        }
        QueryEventsScreen()
    }
}
