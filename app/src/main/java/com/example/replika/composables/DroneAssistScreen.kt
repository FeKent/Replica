package com.example.replika.composables

import android.widget.Toast
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
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
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.replika.R
import com.google.android.gms.maps.model.CameraPosition
import com.google.android.gms.maps.model.LatLng
import com.google.maps.android.compose.CameraPositionState
import com.google.maps.android.compose.Circle
import com.google.maps.android.compose.GoogleMap
import com.google.maps.android.compose.MapProperties
import com.google.maps.android.compose.MapType
import com.google.maps.android.compose.MapUiSettings


@Composable
fun DroneAssistScreen(backHome: () -> Unit) {
    val context = LocalContext.current
    Column(modifier = Modifier.fillMaxSize(1f)) {
        DroneTopAppBar(backHome = backHome)
        Spacer(modifier = Modifier.size(4.dp))
        TopToolBar(modifier = Modifier.fillMaxWidth())
        Spacer(modifier = Modifier.size(4.dp))
        Box(modifier = Modifier.weight(4f)) {
            GoogleMap(
                properties = MapProperties(isBuildingEnabled = true, mapType = MapType.HYBRID),
                uiSettings = MapUiSettings(compassEnabled = true, mapToolbarEnabled = true),
                cameraPositionState = CameraPositionState(
                    CameraPosition(LatLng(51.35, 0.57), 11f, 0f, 0f)
                ),
                modifier = Modifier.shadow(
                    elevation = 4.dp,
                    clip = true,
                    ambientColor = Color.LightGray
                )
            ){
                Circle(
                    center = LatLng(51.38, 0.50),
                    radius = 5000.0,
                    fillColor = Color(178, 38, 77, 100),
                    strokeColor = Color(178, 38, 77,255),
                    strokeWidth = 2f,
                    tag = "Restricted Zone",
                    visible = true,
                    clickable = true,
                    onClick = { Toast.makeText(context,"Restricted Zone", Toast.LENGTH_SHORT).show()}
                )
                Circle(
                    center = LatLng(51.27, 0.52),
                    radius = 3000.0,
                    fillColor = Color(243,181,52, 100),
                    strokeColor = Color(243,181,52,255),
                    strokeWidth = 2f,
                    tag = "Risk Zone",
                    visible = true,
                    clickable = true,
                    onClick = { Toast.makeText(context,"Risk Zone", Toast.LENGTH_SHORT).show()}
                )
                Circle(
                    center = LatLng(51.37, 0.64),
                    radius = 2000.0,
                    fillColor = Color(88,109,255, 100),
                    strokeColor = Color(88,109,255,255),
                    strokeWidth = 2f,
                    tag = "Temporary Restricted Zone",
                    visible = true,
                    clickable = true,
                    onClick = { Toast.makeText(context,"Temporary Restricted Zone", Toast.LENGTH_SHORT).show()}
                )
            }
        }
        Spacer(modifier = Modifier.size(8.dp))
        BottomToolBar()
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
fun TopToolBar(modifier: Modifier = Modifier) {
    Row(modifier) {
        Spacer(modifier = Modifier.size(8.dp))
        Icon(Icons.Filled.Search, "Search", modifier = Modifier
            .size(30.dp)
            .weight(1f)
            .clickable { /*TODO*/ }
        )
        Spacer(modifier = Modifier.size(4.dp))
        Icon(painter = painterResource(id = R.drawable.filter), "Filter", modifier = Modifier
            .size(30.dp)
            .weight(1f)
            .clickable { /*TODO*/ }
        )
        Spacer(modifier = Modifier.size(4.dp))
        Icon(painter = painterResource(id = R.drawable.layers),
            contentDescription = "Map Type",
            modifier = Modifier
                .size(30.dp)
                .weight(1f)
                .clickable { /*TODO*/ }
        )
        Spacer(modifier = Modifier.size(4.dp))
        Row(
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .weight(1f)) {
            Icon(
                painter = painterResource(id = R.drawable.sun),
                contentDescription = "Temperature",
                modifier = Modifier.size(30.dp)
            )
            Spacer(modifier = Modifier.size(2.dp))
            Text(text = "21\u2103", textAlign = TextAlign.Center, fontWeight = FontWeight.SemiBold)
        }
    }
}

@Composable
fun BottomToolBar() {
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

@Preview
@Composable
fun DronePreview() {
    DroneAssistScreen {}
}

@Preview(widthDp = 360, heightDp = 500)
@Composable
fun DroneShort() {
    DroneAssistScreen {

    }
}