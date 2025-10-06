package com.example.kmp_room_database

import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import kmp_room_database.composeapp.generated.resources.Res
import kmp_room_database.composeapp.generated.resources.arrow_left
import kmp_room_database.composeapp.generated.resources.plus_svgrepo_com
import org.jetbrains.compose.resources.painterResource

object Icons {
    @Composable
    fun PLUS(
        modifier: Modifier = Modifier,
        tint: androidx.compose.ui.graphics.Color = MaterialTheme.colorScheme.primary,
        sizeDp: androidx.compose.ui.unit.Dp = 30.dp,
        contentDescription: String = "Plus icon"
    ) {
        Icon(
            painter = painterResource(Res.drawable.plus_svgrepo_com),
            contentDescription = contentDescription,
            modifier = modifier.size(sizeDp),
            tint = tint
        )
    }
    @Composable
    fun ARROW_LEFT(
        modifier: Modifier = Modifier,
        tint: androidx.compose.ui.graphics.Color = MaterialTheme.colorScheme.primary,
        sizeDp: androidx.compose.ui.unit.Dp = 30.dp,
        contentDescription: String = "Plus icon"
    ) {
        Icon(
            painter = painterResource(Res.drawable.arrow_left),
            contentDescription = contentDescription,
            modifier = modifier.size(sizeDp),
            tint = tint
        )
    }
}
