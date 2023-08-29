package com.example.replica.composables

import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

@Composable
fun HomeScreen(changeScreen: ()-> Unit,) {
    Button(onClick = { changeScreen()}) {
        Text(text = "Change Screen")
    }
}