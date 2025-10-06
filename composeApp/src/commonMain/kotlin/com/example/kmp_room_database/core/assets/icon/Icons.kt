package com.example.kmp_room_database.core.assets.icon

import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import kmp_room_database.composeapp.generated.resources.Res
import kmp_room_database.composeapp.generated.resources.arrow_left
import kmp_room_database.composeapp.generated.resources.plus_svgrepo_com
import org.jetbrains.compose.resources.painterResource

object Icons {
    @Composable
    fun PLUS(
        modifier: Modifier = Modifier.Companion,
        tint: Color = Color.Black,
        sizeDp: Dp = 30.dp,
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
        modifier: Modifier = Modifier.Companion,
        tint: Color = Color.Black,
        sizeDp: Dp = 30.dp,
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