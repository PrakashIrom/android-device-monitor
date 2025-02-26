package com.apui.androiddevicemonitor.ui.screens.processing

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.apui.androiddevicemonitor.ui.viewModel.QueryEventsViewModel
import org.koin.compose.viewmodel.koinViewModel

@Composable
fun QueryEventsScreen(viewModel: QueryEventsViewModel = koinViewModel()) {
    val queryEvents = viewModel.queryEvent

    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
    ) {
        items(queryEvents.size) { item ->
            Text(queryEvents[item].appName)
            Text(queryEvents[item].eventType)
            Text(queryEvents[item].timeStamp)
            Spacer(modifier = Modifier.height(8.dp))
        }
    }
}
