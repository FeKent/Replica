package com.example.replika.composables

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.google.android.gms.maps.model.CameraPosition
import com.google.android.gms.maps.model.LatLng
import com.google.maps.android.compose.CameraPositionState
import com.google.maps.android.compose.GoogleMap
import com.google.maps.android.compose.MapProperties
import com.google.maps.android.compose.MapType
import com.google.maps.android.compose.MapUiSettings


@Composable
fun DroneAssistScreen(backHome: () -> Unit) {
    Column(modifier = Modifier.fillMaxSize(1f)) {
        DroneTopAppBar(backHome = backHome)
        Box(modifier = Modifier.weight(4f)) {
            GoogleMap(
                properties = MapProperties(isBuildingEnabled = true, mapType = MapType.HYBRID),
                uiSettings = MapUiSettings(compassEnabled = true, mapToolbarEnabled = true),
                cameraPositionState = CameraPositionState(
                    CameraPosition(LatLng(51.35, 0.57), 10f, 0f, 0f)
                ),
                modifier = Modifier.shadow(
                    elevation = 4.dp,
                    clip = true,
                    ambientColor = Color.LightGray
                )
            )
        }
        Spacer(modifier = Modifier.size(8.dp))
        BottomBar(modifier = Modifier.weight(1f))
        Spacer(modifier = Modifier.size(8.dp))

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
                    Icon(
                        Icons.Filled.Close,
                        "Close",
                        tint = Color(0, 102, 139),
                        modifier = Modifier.clickable { backHome() })
                }
            }
        )
    }
}

@Composable
fun BottomBar(modifier: Modifier = Modifier) {
    Row(
        modifier = Modifier.fillMaxWidth()
    ) {
        Spacer(modifier = Modifier.size(4.dp))
        Icon(
            Icons.Filled.AccountBox, "My Plans", modifier = Modifier
                .weight(1f)
                .size(50.dp)
                .clickable { /*TODO*/ }
        )
        Icon(
            Icons.Filled.LocationOn, "Map", modifier = Modifier
                .weight(1f)
                .size(50.dp)
                .clickable { /*TODO*/ }
        )
        Icon(
            Icons.Filled.Settings, "You", modifier = Modifier
                .weight(1f)
                .size(50.dp)
                .clickable { /*TODO*/ }
        )
    }
}