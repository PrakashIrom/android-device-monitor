package com.apui.androiddevicemonitor.data.repository.performancerepo

import android.app.ActivityManager
import com.apui.androiddevicemonitor.data.models.RunningServices
import com.apui.androiddevicemonitor.domain.repository.performancerepo.RunningServicesRepo

class RunningServicesRepoImpl(
    private val activityManager: ActivityManager,
) : RunningServicesRepo {
    override fun getRunningServices(): List<RunningServices> {
        val runningServices = activityManager.runningAppProcesses ?: return emptyList()

        return runningServices.map { process ->
            RunningServices(
                processName = process.processName,
                pid = process.pid,
                importance = process.importance,
            )
        }
    }
}
