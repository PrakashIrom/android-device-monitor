package com.apui.androiddevicemonitor.ui.screens

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import com.apui.androiddevicemonitor.ui.cards.BatteryCard
import com.apui.androiddevicemonitor.ui.cards.NetworkCard
import com.apui.androiddevicemonitor.ui.cards.ProcessingCard
import com.apui.androiddevicemonitor.ui.cards.SensorCard
import com.apui.androiddevicemonitor.ui.viewModel.TopBarViewModel
import com.apui.androiddevicemonitor.utils.Screens
import org.koin.compose.viewmodel.koinViewModel

@Composable
fun HomeScreen(
    paddingValues: PaddingValues,
    navController: NavHostController,
    viewModel: TopBarViewModel = koinViewModel(),
) {
    LaunchedEffect(Unit) {
        viewModel.currentTopBar(
            isBackButtonVisible = false,
            screen = Screens.HOME,
        )
    }
    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        modifier = Modifier.padding(paddingValues),
    ) {
        items(4) { index ->
            when (index) {
                0 -> BatteryCard(navController)
                1 -> SensorCard(navController)
                2 -> ProcessingCard(navController)
                3 -> NetworkCard(navController)
            }
        }
    }
}
