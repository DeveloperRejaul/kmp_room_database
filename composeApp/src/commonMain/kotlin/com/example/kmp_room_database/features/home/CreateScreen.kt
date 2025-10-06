package com.example.kmp_room_database.features.home


import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.kmp_room_database.LocalDatabase
import com.example.kmp_room_database.core.assets.icon.Icons
import com.example.kmp_room_database.core.database.todo.TodoEntity
import com.example.kmp_room_database.core.navigation.Routes
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun  CreateScreen(navController: NavHostController, params: Routes.Create) {
    val title = mutableStateOf(params.title ?: "")
    val content = mutableStateOf(params.content ?: "")
    val dao = LocalDatabase.current.getDao()
    val scope = rememberCoroutineScope()


    Scaffold (
        topBar = {
            TopAppBar(
                title = {
                    Text(if(params.isEmpty()) "Create" else "Update")
                },
                navigationIcon = {
                    IconButton( onClick = {
                        navController.popBackStack()
                    }){
                        Icons.ARROW_LEFT()
                    }
                },
            );
        }
    ) { innerPadding ->
        Column(modifier = Modifier.padding(innerPadding).padding(horizontal = 16.dp)) {
            TextField(
                value = title.value,
                onValueChange = {it -> title.value = it},
                label = {Text("Title")},
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(modifier = Modifier.height(10.dp))
            TextField(
                value = content.value,
                onValueChange = {it -> content.value = it},
                label = {Text("Content")},
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(modifier = Modifier.height(10.dp))
            Button(
                onClick = {
                    scope.launch {
                        if(params.isEmpty()) {
                            dao.insert(TodoEntity(title = title.value, content = content.value))
                        } else {
                            if(params.id != null) {
                                dao.update(TodoEntity(id = params.id, title = title.value, content = content.value))
                            }
                        }
                        navController.popBackStack()
                    }
                },
                modifier = Modifier.fillMaxWidth().height(50.dp),
                shape = RoundedCornerShape(5.dp)
            ){
                Text(if(params.isEmpty()) "Create" else "Update")
            }
        }
    }
}