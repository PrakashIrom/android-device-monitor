package com.apui.androiddevicemonitor.domain.repository.performancerepo

import com.apui.androiddevicemonitor.data.models.RunningServices

interface RunningServicesRepo {
    fun getRunningServices(): List<RunningServices>
}
