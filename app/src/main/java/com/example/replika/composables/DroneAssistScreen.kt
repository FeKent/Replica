package com.example.replika.composables

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.google.maps.android.compose.GoogleMap
import com.google.maps.android.compose.MapProperties


@Composable
fun DroneAssistScreen(backHome: () -> Unit) {
    Column {
        DroneTopAppBar(backHome = backHome)
        GoogleMap(properties = MapProperties(isBuildingEnabled = true)) {}
    }

}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DroneTopAppBar(backHome: () -> Unit) {
    Surface(shadowElevation = 6.dp, modifier = Modifier.fillMaxWidth()) {
        CenterAlignedTopAppBar(title = {
            Text(
                text = "Altitude Angel - Drone Assist",
                color = Color(135, 187, 70, 255),
                fontWeight = FontWeight.SemiBold,
                fontSize = 20.sp
            )
        },
            navigationIcon = {
                IconButton({}) {
                    Icon(Icons.Filled.Close, "Close", tint = Color(0, 102, 139), modifier = Modifier.clickable { backHome() })
                }
            }
        )
    }

}