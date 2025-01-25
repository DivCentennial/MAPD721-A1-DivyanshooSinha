package com.example.mapd721_a1_divyanshoosinha

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.mapd721_a1_divyanshoosinha.ui.theme.MAPD721A1DivyanshooSinhaTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MAPD721A1DivyanshooSinhaTheme {
                MainScreen()
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen() {
    var id by remember { mutableStateOf("") }
    var username by remember { mutableStateOf("") }
    var courseName by remember { mutableStateOf("") }

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {
            TopAppBar(
                title = { Text("Assignment 1") },
                modifier = Modifier.fillMaxWidth()
            )
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .padding(16.dp)
                .fillMaxSize(),
            verticalArrangement = Arrangement.SpaceBetween,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // Input Fields
            Column(
                modifier = Modifier.fillMaxWidth(),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                TextField(
                    value = id,
                    onValueChange = { id = it },
                    label = { Text("ID") },
                    modifier = Modifier.fillMaxWidth()
                )
                TextField(
                    value = username,
                    onValueChange = { username = it },
                    label = { Text("Username") },
                    modifier = Modifier.fillMaxWidth()
                )
                TextField(
                    value = courseName,
                    onValueChange = { courseName = it },
                    label = { Text("Course Name") },
                    modifier = Modifier.fillMaxWidth()
                )
            }

            // Buttons
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                Button(onClick = { /* Load functionality */ }) {
                    Text("Load")
                }
                Button(onClick = { /* Store functionality */ }) {
                    Text("Store")
                }
                Button(onClick = {
                    id = ""
                    username = ""
                    courseName = ""
                }) {
                    Text("Reset")
                }
            }

            // About Section
            Text(
                text = "About: Divyanshoo Sinha (Student ID: 721XXXXX)",
                style = MaterialTheme.typography.bodyLarge,
                modifier = Modifier.align(Alignment.CenterHorizontally)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun MainScreenPreview() {
    MAPD721A1DivyanshooSinhaTheme {
        MainScreen()
    }
}
