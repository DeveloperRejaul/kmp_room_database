package com.example.kmp_room_database.features.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.kmp_room_database.LocalDatabase
import com.example.kmp_room_database.core.assets.icon.Icons
import com.example.kmp_room_database.core.components.TodoItem
import com.example.kmp_room_database.core.navigation.Routes
import kotlinx.coroutines.launch


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(navController: NavHostController) {
    val dao = LocalDatabase.current.getDao()
    val todos = dao.getAllAsFlow().collectAsState(emptyList())
    val scope = rememberCoroutineScope()

    Scaffold(
        floatingActionButton = {
            FloatingActionButton(
                onClick = {
                    navController.navigate(Routes.Create())
                },
            ) {
                Icons.PLUS()
            }
        },
        topBar = {
            TopAppBar(title = {
                Text(
                    "ROOM DB - TODO APP",
                    fontWeight = FontWeight.Bold,
                    fontSize = 20.sp
                )
            })
        }
    ) { innerPadding ->
        Column(modifier = Modifier.padding(innerPadding)) {
            LazyVerticalGrid(
                modifier = Modifier.fillMaxSize().padding(horizontal = 20.dp),
                verticalArrangement = Arrangement.spacedBy(10.dp),
                horizontalArrangement = Arrangement.spacedBy(12.dp),
                columns = GridCells.Fixed(2)
            ) {
                items(todos.value) { todo ->
                    TodoItem(
                        todo,
                        onEdit = { navController.navigate(Routes.Create(it.id, it.title, it.content))},
                        onDelete = {
                            scope.launch {
                                dao.removeById(it.id)
                            }
                        }
                    )
                }
            }
        }
    }
}
