package com.apui.androiddevicemonitor.ui.viewModel

import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.lifecycle.ViewModel
import com.apui.androiddevicemonitor.data.models.Event
import com.apui.androiddevicemonitor.domain.usecases.performanceusecases.GetQueryEventsUseCase

class QueryEventsViewModel(
    queryEventsUseCase: GetQueryEventsUseCase,
) : ViewModel() {
    private val _queryEvent = mutableStateListOf<Event>()
    val queryEvent: SnapshotStateList<Event> = _queryEvent

    init {
        _queryEvent.addAll(queryEventsUseCase.invoke())
    }
}
