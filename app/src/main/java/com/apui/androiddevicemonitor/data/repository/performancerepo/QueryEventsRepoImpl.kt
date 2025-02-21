package com.apui.androiddevicemonitor.data.repository.performancerepo

import android.app.usage.UsageEvents
import android.app.usage.UsageStatsManager
import com.apui.androiddevicemonitor.data.models.Event
import com.apui.androiddevicemonitor.domain.repository.performancerepo.QueryEventsRepo

class QueryEventsRepoImpl(
    private val usageManager: UsageStatsManager,
) : QueryEventsRepo {
    override fun getQueryEvents(
        beginTime: Long,
        endTime: Long,
    ): List<Event> {
        val evenList = mutableListOf<Event>()
        val events = usageManager.queryEvents(beginTime, endTime)
        val event = UsageEvents.Event()

        while (events.hasNextEvent()) {
            events.getNextEvent(event)
            evenList.add(
                Event(
                    packageName = event.packageName,
                    eventType = event.eventType,
                    timeStamp = event.timeStamp,
                ),
            )
        }

        return evenList
    }
}
