package com.apui.androiddevicemonitor.ui.viewModel

import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.lifecycle.ViewModel
import com.apui.androiddevicemonitor.data.models.RunningServices
import com.apui.androiddevicemonitor.domain.usecases.performanceusecases.GetRunningServicesUseCase

class RunningServicesViewModel(
    getRunningServicesUseCase: GetRunningServicesUseCase,
) : ViewModel() {
    private val _runningServices = mutableStateListOf<RunningServices>()
    val runningServices: SnapshotStateList<RunningServices> = _runningServices

    init {
        _runningServices.addAll(getRunningServicesUseCase())
    }
}
