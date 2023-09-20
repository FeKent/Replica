package com.example.replika.composables

import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable

@Composable
fun GmailScreen(backHome: () -> Unit) {
    TextButton(onClick = { backHome()}) {
        Text(text = "Back")
    }
}