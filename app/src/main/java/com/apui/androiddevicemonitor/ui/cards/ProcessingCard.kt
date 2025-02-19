package com.apui.androiddevicemonitor.ui.cards

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import com.apui.androiddevicemonitor.R
import com.apui.androiddevicemonitor.utils.CustomCard

@Composable
fun ProcessingCard(navController: NavHostController) {
    CustomCard(
        titleId = R.string.Processing,
        iconRes = R.drawable.process,
        onClick = { navController.navigate("processing") },
    )
}
