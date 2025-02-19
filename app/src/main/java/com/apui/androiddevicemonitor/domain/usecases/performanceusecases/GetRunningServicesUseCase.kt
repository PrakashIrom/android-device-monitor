package com.apui.androiddevicemonitor.domain.usecases.performanceusecases

import com.apui.androiddevicemonitor.data.models.RunningServices
import com.apui.androiddevicemonitor.domain.repository.performancerepo.RunningServicesRepo

class GetRunningServicesUseCase(
    private val runningServicesRepo: RunningServicesRepo,
) {
    operator fun invoke(): List<RunningServices> = runningServicesRepo.getRunningServices()
}
