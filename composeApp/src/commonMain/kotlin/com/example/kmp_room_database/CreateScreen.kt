package com.example.kmp_room_database

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
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun  CreateScreen(navController: NavHostController) {
    val title = mutableStateOf("")
    val content = mutableStateOf("")
    Scaffold (
        topBar = {
            TopAppBar(
                title = {
                    Text("Create")
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
                onClick = {},
                modifier = Modifier.fillMaxWidth().height(50.dp),
                shape = RoundedCornerShape(5.dp)
            ){
                Text("Create")
            }
        }
    }

}