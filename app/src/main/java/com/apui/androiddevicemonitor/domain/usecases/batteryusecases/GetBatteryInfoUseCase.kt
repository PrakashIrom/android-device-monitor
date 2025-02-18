package com.apui.androiddevicemonitor.domain.usecases.batteryusecases

import android.content.Intent
import com.apui.androiddevicemonitor.data.models.BatteryInfo
import com.apui.androiddevicemonitor.domain.repository.BatteryInfoRepo

class GetBatteryInfoUseCase(private val batteryInfoRepo: BatteryInfoRepo) {
    operator fun invoke(intent: Intent): BatteryInfo {
        return batteryInfoRepo.getBatteryInfo(intent)
    }
}