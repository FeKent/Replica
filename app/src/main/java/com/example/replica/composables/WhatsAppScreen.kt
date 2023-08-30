@file:OptIn(ExperimentalMaterial3Api::class)

package com.example.replica.composables

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.paint
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.replica.R


@Composable
fun WhatsAppScreen(backHome: () -> Unit) {

    Box(modifier = with(Modifier) {
        fillMaxSize().paint(
            painterResource(R.drawable.whatsapp_background),
            contentScale = ContentScale.FillBounds
        )
    }) {
        Column(modifier = Modifier.verticalScroll(rememberScrollState())) {
            WhatsAppBar(backHome = backHome)
            Spacer(modifier = Modifier.size(16.dp))
            IncomingMessage(
                message = "The false moustache! Quelle Horreur! Never, in the whole of London, have I seen a pair of moustaches to equal mine.",
                time = "10:03"
            )
            OutgoingMessage(
                message = "Oh, Mr. Poirot, remember, it's not the size of the moustache that matters, but the sharpness of the mind behind it.",
                time = "10:05"
            )

        }
    }
}


@Composable
fun IncomingMessage(message: String, time: String) {
    Row(
        modifier = Modifier
            .padding(start = 8.dp, end = 55.dp)
    ) {
        Box(
            modifier = Modifier
                .background(color = Color.White, shape = RoundedCornerShape(5.dp))
                .padding(8.dp)
                .width(350.dp)
        ) {
            Text(
                text = message,
                textAlign = TextAlign.Start,
                fontSize = 14.sp,
                lineHeight = 16.sp,

            )
            Text(
                text = time,
                color = Color.Gray,
                fontSize = 12.sp,
                fontWeight = FontWeight.SemiBold,
                textAlign = TextAlign.Center,
                modifier = Modifier.align(Alignment.BottomEnd)
            )
        }

    }
    Spacer(modifier = Modifier.size(8.dp))
}

@Composable
fun OutgoingMessage(message: String, time: String) {
    Row(
        modifier = Modifier
            .padding(start = 55.dp, end = 8.dp)
    ) {
        Box(
            modifier = Modifier
                .background(color = Color(231, 255, 219, 255), shape = RoundedCornerShape(5.dp))
                .padding(8.dp)
                .width(350.dp)
        ) {
            Text(
                text = message,
                textAlign = TextAlign.Start,
                fontSize = 14.sp,
                lineHeight = 16.sp
            )
            Row(modifier = Modifier.align(Alignment.BottomEnd)) {
                Text(
                    text = time,
                    color = Color.Gray,
                    fontSize = 12.sp,
                    fontWeight = FontWeight.SemiBold,
                    textAlign = TextAlign.Center,
                    modifier = Modifier.padding(top = 4.dp)
                )
                Spacer(modifier = Modifier.size(4.dp))
                Icon(
                    painter = painterResource(id = R.drawable.double_check),
                    "Notification Check",
                    tint = Color(20, 152, 201, 255),
                    modifier = Modifier
                        .size(20.dp)
                        .padding(0.dp)
                )
            }
        }
    }
    Spacer(modifier = Modifier.size(8.dp))
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun WhatsAppBar(backHome: () -> Unit) {
    TopAppBar(
        title = {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.fillMaxWidth()
            ) {
                Image(
                    painter = painterResource(R.drawable.poirot_avatar),
                    "Profile Picture",
                    modifier = Modifier.size(40.dp)
                )
                Spacer(modifier = Modifier.size(8.dp))
                Text(
                    text = "Hercule Poirot",
                    color = Color.White,
                    fontWeight = FontWeight.SemiBold,
                    modifier = Modifier.fillMaxWidth(1f)
                )

            }
        },
        navigationIcon = {
            IconButton(onClick = { backHome() }) {
                Icon(
                    Icons.Filled.ArrowBack,
                    "Back",
                    tint = Color.White,
                    modifier = Modifier.size(20.dp)
                )
            }
        },
        actions = {
            Icon(
                painter = painterResource(id = R.drawable.video_call),
                tint = Color.White,
                contentDescription = "Video Call"
            )
            Spacer(modifier = Modifier.size(16.dp))
            Icon(Icons.Filled.Call, tint = Color.White, contentDescription = "Call Icon")
            Spacer(modifier = Modifier.size(8.dp))
            Icon(Icons.Filled.MoreVert, tint = Color.White, contentDescription = "More Options")
        },
        colors = TopAppBarDefaults.smallTopAppBarColors(
            containerColor = Color(0, 128, 105, 255)
        ),
        modifier = Modifier.background(color = Color.LightGray)
    )
}
