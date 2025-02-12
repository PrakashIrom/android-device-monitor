package com.apui.androiddevicemonitor.ui.cards

import androidx.compose.runtime.Composable
import com.apui.androiddevicemonitor.R
import com.apui.androiddevicemonitor.utils.CustomCard

@Composable
fun ProcessingCard(){
    CustomCard(titleId = R.string.Processing, iconRes = R.drawable.process)
}