package com.apui.androiddevicemonitor.ui.screens

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.apui.androiddevicemonitor.ui.cards.BatteryCard
import com.apui.androiddevicemonitor.ui.cards.NetworkCard
import com.apui.androiddevicemonitor.ui.cards.ProcessingCard
import com.apui.androiddevicemonitor.ui.cards.SensorCard

@Composable
fun HomeScreen(paddingValues: PaddingValues) {
    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        modifier = Modifier.padding(paddingValues)
    ) {
        items(4) { index ->
            when (index) {
                0 -> BatteryCard()
                1 -> SensorCard()
                2 -> ProcessingCard()
                3 -> NetworkCard()
            }
        }
    }
}