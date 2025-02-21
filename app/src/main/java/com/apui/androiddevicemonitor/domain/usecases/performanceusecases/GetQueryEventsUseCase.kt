package com.apui.androiddevicemonitor.domain.usecases.performanceusecases

import com.apui.androiddevicemonitor.domain.repository.performancerepo.QueryEventsRepo

class GetQueryEventsUseCase(
    private val queryEventsRepo: QueryEventsRepo,
) {
    private val startTime = System.currentTimeMillis() - 60 * 60 * 1000
    private val endTime = System.currentTimeMillis()

    operator fun invoke() = queryEventsRepo.getQueryEvents(startTime, endTime)
}
