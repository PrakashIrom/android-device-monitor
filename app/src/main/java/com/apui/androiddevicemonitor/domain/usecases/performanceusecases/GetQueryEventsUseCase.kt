package com.apui.androiddevicemonitor.domain.usecases.performanceusecases

import android.app.usage.UsageEvents
import android.content.Context
import android.content.pm.PackageManager
import com.apui.androiddevicemonitor.domain.model.QueryEvent
import com.apui.androiddevicemonitor.domain.repository.performancerepo.QueryEventsRepo
import com.apui.androiddevicemonitor.utils.convertDate
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class GetQueryEventsUseCase(
    private val queryEventsRepo: QueryEventsRepo,
    private val context: Context,
) {
    private val startTime = System.currentTimeMillis() - 60 * 60 * 1000
    private val endTime = System.currentTimeMillis()

    suspend operator fun invoke(): List<QueryEvent> =
        withContext(Dispatchers.IO) {
            val queryEvents = queryEventsRepo.getQueryEvents(startTime, endTime)
            queryEvents.map { event ->
                QueryEvent(
                    appName = getAppName(context, event.packageName),
                    eventType = getEventTypeName(event.eventType),
                    timeStamp = event.timeStamp.convertDate(),
                )
            }
        }

    private fun getEventTypeName(eventType: Int): String =
        when (eventType) {
            UsageEvents.Event.ACTIVITY_RESUMED -> "Activity Resumed"
            UsageEvents.Event.ACTIVITY_PAUSED -> "Activity Paused"
            UsageEvents.Event.USER_INTERACTION -> "User Interaction"
            UsageEvents.Event.CONFIGURATION_CHANGE -> "Configuration Change"
            UsageEvents.Event.SHORTCUT_INVOCATION -> "Shortcut Invocation"
            else -> "Unknown Event ($eventType)"
        }

    private fun getAppName(
        context: Context,
        packageName: String,
    ): String =
        try {
            val packageManager = context.packageManager
            val appInfo =
                packageManager.getApplicationInfo(packageName, PackageManager.GET_META_DATA)
            packageManager.getApplicationLabel(appInfo).toString()
        } catch (e: PackageManager.NameNotFoundException) {
            packageName // Fallback to package name if app name is not found
        }
}
