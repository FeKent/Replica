package com.example.replika.composables

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
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
import com.google.android.gms.maps.model.CameraPosition
import com.google.android.gms.maps.model.LatLng
import com.google.maps.android.compose.CameraPositionState
import com.google.maps.android.compose.GoogleMap
import com.google.maps.android.compose.MapProperties


@Composable
fun DroneAssistScreen(backHome: () -> Unit) {
    Column(modifier = Modifier.fillMaxSize(1f)) {
        DroneTopAppBar(backHome = backHome)
        Spacer(modifier = Modifier.size(6.dp))
        Box(modifier = Modifier.fillMaxHeight(0.75f)) {
            GoogleMap(properties = MapProperties(isBuildingEnabled = true), cameraPositionState = CameraPositionState(
                CameraPosition(LatLng(51.35, 0.57), 10f, 0f, 0f)
            )) {}
        }

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