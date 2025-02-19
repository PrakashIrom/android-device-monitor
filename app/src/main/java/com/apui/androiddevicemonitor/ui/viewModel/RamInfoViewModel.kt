package com.apui.androiddevicemonitor.ui.viewModel

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.apui.androiddevicemonitor.domain.model.RamUsageInfo
import com.apui.androiddevicemonitor.domain.usecases.performanceusecases.GetRamInfoUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class RamInfoViewModel(
    ramInfoUseCase: GetRamInfoUseCase,
) : ViewModel() {
    private val _ramUsageInfo = mutableStateOf(RamUsageInfo("", "", ""))
    var ramUsageInfo: State<RamUsageInfo> = _ramUsageInfo

    init {
        viewModelScope.launch(Dispatchers.IO) {
            val info = ramInfoUseCase()
            withContext(Dispatchers.Main) {
                _ramUsageInfo.value = info
            }
        }
    }
}
