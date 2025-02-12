package com.apui.androiddevicemonitor.utils

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp

@Composable
fun CustomCard(titleId: Int, iconRes: Int, onClick: () -> Unit = {}) {
    Card(
        modifier = Modifier
            .size(height = 250.dp, width = 100.dp)
            .padding(all = 10.dp)
            .clickable { onClick() },
    ) {
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.padding(top = 10.dp)
        ) {
            Icon(
                painter = painterResource(id = iconRes),
                contentDescription = stringResource(titleId),
                tint = Color.Unspecified
            )
            Spacer(modifier = Modifier.height(7.dp))
            Text(
                stringResource(titleId),
                fontWeight = FontWeight.W600
            )
        }
    }
}