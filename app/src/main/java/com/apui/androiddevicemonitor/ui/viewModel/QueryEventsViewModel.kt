package com.apui.androiddevicemonitor.ui.viewModel

import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.apui.androiddevicemonitor.domain.model.QueryEvent
import com.apui.androiddevicemonitor.domain.usecases.performanceusecases.GetQueryEventsUseCase
import kotlinx.coroutines.launch

class QueryEventsViewModel(
    private val queryEventsUseCase: GetQueryEventsUseCase,
) : ViewModel() {
    private val _queryEvent = mutableStateListOf<QueryEvent>()
    val queryEvent: SnapshotStateList<QueryEvent> = _queryEvent

    init {
        refreshQueryEvents()
    }

    private fun refreshQueryEvents() {
        viewModelScope.launch {
            _queryEvent.clear()
            _queryEvent.addAll(queryEventsUseCase.invoke())
        }
    }
}
