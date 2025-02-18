package com.apui.androiddevicemonitor.ui.viewModel

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.apui.androiddevicemonitor.domain.model.RamUsageInfo
import com.apui.androiddevicemonitor.domain.usecases.performanceusecases.GetRamInfoUseCase

class RamInfoViewModel(ramInfoUseCase: GetRamInfoUseCase) : ViewModel() {

    private val _ramUsageInfo = mutableStateOf(RamUsageInfo("", "", ""))
    var ramUsageInfo: State<RamUsageInfo> = _ramUsageInfo

    init {
        _ramUsageInfo.value = ramInfoUseCase()
    }

}