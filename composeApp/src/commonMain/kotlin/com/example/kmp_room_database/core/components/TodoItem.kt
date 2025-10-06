package com.example.kmp_room_database.core.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.kmp_room_database.core.database.todo.TodoEntity

@Composable
fun TodoItem (
    item: TodoEntity,
    onDelete: (item: TodoEntity) -> Unit,
    onEdit: (item: TodoEntity) -> Unit
) {
    val (id, title, content) = item
    Card(
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surfaceVariant),
        modifier = Modifier.height(200.dp).fillMaxWidth()
    ) {
        Column (
            modifier = Modifier.padding(10.dp).fillMaxSize(),
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            Column {
               Row (
                   modifier = Modifier.fillMaxWidth(),
                   horizontalArrangement = Arrangement.SpaceBetween,
                   verticalAlignment = Alignment.CenterVertically
               ) {
                   Text(
                       text = "#${id}",
                       textAlign = TextAlign.Center,
                   )
                   Text(
                       "Edit",
                       color = MaterialTheme.colorScheme.primary,
                       fontWeight = FontWeight.Bold,
                       fontSize = 12.sp,
                       modifier = Modifier.padding(horizontal = 10.dp).clickable(onClick = {onEdit(item)})
                   )
               }
                Text(
                    text = title.trim(),
                    textAlign = TextAlign.Start,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
                Text(
                    text = content.trim(),
                    textAlign = TextAlign.Start,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Normal,
                    maxLines = 3,
                    overflow = TextOverflow.Ellipsis
                )
            }
            Button(
                onClick = {
                    onDelete(item)
                },
                shape = RoundedCornerShape(5.dp),
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("Remove")
            }
        }
    }
}