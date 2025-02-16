package com.apui.androiddevicemonitor.ui.viewModel

import android.app.Application
import android.content.Intent
import android.content.IntentFilter
import androidx.lifecycle.AndroidViewModel
import com.apui.androiddevicemonitor.data.models.BatteryInfo
import com.apui.androiddevicemonitor.receivers.BatteryReceiver
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class BatteryInfoViewModel(application: Application) : AndroidViewModel(application) {

    private val _batteryInfo = MutableStateFlow(
        BatteryInfo(
            0,
            "",
            0.0,
            "",
            "",
            0.0
        )
    )
    val batteryInfo: StateFlow<BatteryInfo> = _batteryInfo
    private val batteryReceiver = BatteryReceiver { value ->
        _batteryInfo.value = value
    }

    init {
        application.registerReceiver(batteryReceiver, IntentFilter(Intent.ACTION_BATTERY_CHANGED))
    }

    /*The onCleared() function in ViewModel is called when the ViewModel is about to be destroyed.
      This usually happens when the associated Activity or Fragment is finishing.*/
    override fun onCleared() {
        super.onCleared()
        getApplication<Application>().unregisterReceiver(batteryReceiver)
    }

}
