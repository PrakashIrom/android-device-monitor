package com.apui.androiddevicemonitor.ui.cards

import androidx.compose.runtime.Composable
import com.apui.androiddevicemonitor.R
import com.apui.androiddevicemonitor.utils.CustomCard

@Composable
fun NetworkCard(){
    CustomCard(titleId = R.string.Network, iconRes = R.drawable.mobile_network)
}