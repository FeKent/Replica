package com.example.replika.composables

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable


@Composable
fun DroneAssistScreen(backHome:() -> Unit) {
    Column {
        Button(onClick = { backHome()}) {
            Text(text = "Test")
        }
    }

}