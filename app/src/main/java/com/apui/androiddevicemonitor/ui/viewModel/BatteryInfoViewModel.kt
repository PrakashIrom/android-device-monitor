package com.apui.androiddevicemonitor.ui.viewModel

import android.app.Application
import android.content.Intent
import android.content.IntentFilter
import androidx.lifecycle.AndroidViewModel
import com.apui.androiddevicemonitor.data.models.BatteryInfo
import com.apui.androiddevicemonitor.domain.usecases.batteryusecases.GetBatteryInfoUseCase
import com.apui.androiddevicemonitor.receivers.BatteryReceiver
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class BatteryInfoViewModel(
    application: Application,
    private val getBatteryInfoUseCase: GetBatteryInfoUseCase,
) : AndroidViewModel(application) {

    /*isReceiverRegistered is used to check if the receiver is already registered because
     "java.lang.IllegalArgumentException: Receiver not registered" happens when we try to unregister the
    batteryReceiver in onCleared(), but it might not be registered at that point.*/
    private var isReceiverRegistered = false

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
    private val batteryReceiver = BatteryReceiver { intent ->
        updateBatteryInfo(intent)
    }

    private fun updateBatteryInfo(intent: Intent) {
        _batteryInfo.value = getBatteryInfoUseCase(intent)
    }

    init {
        if (!isReceiverRegistered) {
            application.registerReceiver(
                batteryReceiver,
                IntentFilter(Intent.ACTION_BATTERY_CHANGED)
            )
            isReceiverRegistered = true
        }
    }

    /*The onCleared() function in ViewModel is called when the ViewModel is about to be destroyed.
      This usually happens when the associated Activity or Fragment is finishing.*/
    override fun onCleared() {
        super.onCleared()
        if (isReceiverRegistered) {
            getApplication<Application>().unregisterReceiver(batteryReceiver)
            isReceiverRegistered = false
        }
    }

}
