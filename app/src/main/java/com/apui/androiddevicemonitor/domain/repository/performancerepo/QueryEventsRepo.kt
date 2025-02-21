package com.apui.androiddevicemonitor.domain.repository.performancerepo

import com.apui.androiddevicemonitor.data.models.Event

interface QueryEventsRepo {
    fun getQueryEvents(
        beginTime: Long,
        endTime: Long,
    ): List<Event>
}
