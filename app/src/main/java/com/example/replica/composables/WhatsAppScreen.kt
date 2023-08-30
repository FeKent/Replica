@file:OptIn(ExperimentalMaterial3Api::class)

package com.example.replica.composables

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.paint
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.replica.R


@Composable
fun WhatsAppScreen(backHome: () -> Unit) {
    WhatsAppBar(backHome = backHome)
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun WhatsAppBar(backHome: () -> Unit) {
    Box(modifier = with(Modifier) {
        fillMaxSize().paint(
            painterResource(R.drawable.whatsapp_background),
            contentScale = ContentScale.FillBounds
        )
    }) {
        TopAppBar(title = {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.fillMaxWidth()
            ) {
                Icon(Icons.Filled.Person, "Profile Picture", modifier = Modifier.size(30.dp))
                Spacer(modifier = Modifier.size(8.dp))
                Text(text = "Hercule Poirot", modifier = Modifier.fillMaxWidth(1f))

            }
        }, navigationIcon = {
            IconButton(onClick = { backHome() }) {
                Icon(Icons.Filled.ArrowBack, "Back", modifier = Modifier.size(20.dp))
            }
        }, actions = {
            Icon(
                painter = painterResource(id = R.drawable.video_call),
                contentDescription = "Video Call"
            )
            Spacer(modifier = Modifier.size(16.dp))
            Icon(Icons.Filled.Call, "Call Icon")
            Spacer(modifier = Modifier.size(8.dp))
            Icon(Icons.Filled.MoreVert, "More Options")
        },
            modifier = Modifier.background(color = Color.LightGray)
        )
    }
}