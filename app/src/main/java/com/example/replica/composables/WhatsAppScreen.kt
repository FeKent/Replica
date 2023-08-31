@file:OptIn(ExperimentalMaterial3Api::class)

package com.example.replica.composables

import android.content.res.Configuration
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.paint
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.replica.R


@Composable
fun WhatsAppScreen(backHome: () -> Unit) {
    var message by remember { mutableStateOf("") }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .paint(
                painterResource(R.drawable.whatsapp_background),
                contentScale = ContentScale.FillBounds
            )
    ) {
        Column(
            modifier = Modifier
                .fillMaxHeight()
                .padding(bottom = 8.dp)
        ) {
            WhatsAppBar(backHome = backHome)
            Column(
                modifier = Modifier
                    .weight(1f)
                    .verticalScroll(rememberScrollState())
            ) {
                Column {
                    TimeStamp(date = "Monday")
                    IncomingMessage(
                        message = "The false moustache! Quelle Horreur! Never, in the whole of London, have I seen a pair of moustaches to equal mine.",
                        time = "10:03"
                    )
                    OutgoingMessage(
                        message = "Oh, Mr. Poirot, remember, it's not the size of the moustache that matters, but the sharpness of the mind behind it.",
                        time = "10:05"
                    )
                    IncomingMessage(
                        message = "Ah, Miss Marple, your wisdom always shines brighter than the most polished waxed tips. Indeed, it is the little grey cells that truly distinguish a detective, not the follicular extravagance.",
                        time = "10:08"
                    )
                    OutgoingMessage(
                        message = "Quite right, Mr. Poirot. Just as a well-trimmed garden reveals hidden beauty, so does a keen intellect uncover the truth amidst the thickest of mysteries.",
                        time = "10:13"
                    )
                    TimeStamp(date = "Today")
                    IncomingMessage(
                        message = "My dear Miss Marple, a perplexing case has crossed my path. The disappearance of Lady Fotherington's priceless pearls leaves me intrigued.",
                        time = "08:23"
                    )
                    OutgoingMessage(
                        message = "Ah, Mr. Poirot, pearls may be lustrous, but they can also hide secrets within their layers. Remember, it's often the most unassuming oyster that holds the key.",
                        time = "08:48"
                    )
                    IncomingMessage(
                        message = "Très vrai, Miss Marple. Just as a diamond's facets reflect light, so must we examine every angle to reveal the hidden facets of truth.",
                        time = "08:57"
                    )
                    IncomingMessage(
                        message = "The parallels in our methods never cease to amaze me, Miss Marple. In pearls and puzzles alike, it is the patience and precision that lead to revelations.",
                        time = "08:59"
                    )
                    OutgoingMessage(
                        message = "Patience, precision, and a touch of empathy, Mr. Poirot. Just as threads bind a tapestry, our qualities entwine to solve even the most intricate enigmas.",
                        time = "09:02"
                    )
                }
                Spacer(modifier = Modifier.weight(1f))
            }
            NewMessage(value = message, onValueChange = { message = it })
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NewMessage(value: String, onValueChange: (String) -> Unit) {
    Spacer(modifier = Modifier.size(6.dp))
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 8.dp)
    ) {
        Row(
            modifier = Modifier
                .padding(end = 4.dp)
                .weight(1f)
                .background(color = Color.White, shape = RoundedCornerShape(50.dp))
        ) {
            Spacer(modifier = Modifier.size(4.dp))
            Icon(
                painter = painterResource(id = R.drawable.emoji_icon),
                contentDescription = "Emoticon Option",
                tint = Color(139, 152, 161, 255),
                modifier = Modifier.align(Alignment.CenterVertically)
            )
            TextField(
                value = value,
                onValueChange = { onValueChange(it) },
                singleLine = true,
                label = { Text(text = "Message") },
                keyboardOptions = KeyboardOptions(
                    imeAction = ImeAction.Send,
                    capitalization = KeyboardCapitalization.Sentences
                ),
                colors = TextFieldDefaults.textFieldColors(
                    containerColor = Color.White,
                    focusedIndicatorColor = Color.White,
                    unfocusedIndicatorColor = Color.White
                ),
                modifier = Modifier.weight(1f)
            )
            Icon(
                painter = painterResource(id = R.drawable.file),
                "Attach File",
                tint = Color(139, 152, 161, 255),
                modifier = Modifier.align(Alignment.CenterVertically)
            )
            Icon(
                painter = painterResource(id = R.drawable.camera),
                "Take Picture",
                tint = Color(139, 152, 161, 255),
                modifier = Modifier.align(Alignment.CenterVertically)
            )
            Spacer(modifier = Modifier.size(4.dp))
        }
        Icon(
            painter = painterResource(id = R.drawable.microphone),
            "Take Picture",
            tint = Color.White,
            modifier = Modifier
                .align(Alignment.CenterVertically)
                .background(color = Color(0, 168, 132, 255), shape = CircleShape)
                .padding(10.dp)
        )
    }
}


@Composable
fun TimeStamp(date: String) {
    Box(
        modifier = Modifier
            .padding(4.dp)
            .fillMaxWidth()
    ) {
        Text(
            text = date,
            fontSize = 14.sp,
            fontWeight = FontWeight.SemiBold,
            color = Color(86, 100, 108),
            modifier = Modifier
                .background(Color(247, 247, 247, 255), shape = RoundedCornerShape(4.dp))
                .padding(4.dp)
                .align(Alignment.Center)
        )
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
                .weight(1f)
        ) {
            Column {
                Text(
                    text = message,
                    textAlign = TextAlign.Start,
                    fontSize = 16.sp,
                    lineHeight = 16.sp,
                    color = Color.Black
                )
                Row(horizontalArrangement = Arrangement.End, modifier = Modifier.fillMaxWidth()) {
                    Text(
                        text = time,
                        color = Color.Gray,
                        fontSize = 12.sp,
                        fontWeight = FontWeight.SemiBold,
                        textAlign = TextAlign.End,
                    )
                }
            }
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
                .weight(1f)
        ) {
            Column {
                Text(
                    text = message,
                    textAlign = TextAlign.Start,
                    fontSize = 16.sp,
                    lineHeight = 16.sp,
                    color = Color.Black
                )
                Row(horizontalArrangement = Arrangement.End, modifier = Modifier.fillMaxWidth()) {
                    Text(
                        text = time,
                        color = Color.Gray,
                        fontSize = 12.sp,
                        fontWeight = FontWeight.SemiBold,
                        textAlign = TextAlign.End,
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
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis,
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

@Preview
@Composable
fun WhatsAppScreenPreview() {
    WhatsAppScreen {

    }
}

@Preview(widthDp = 360, heightDp = 500)
@Composable
fun WhatsAppScreenPreviewShort() {
    WhatsAppScreen {

    }
}

@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun WhatsAppPreviewDarkMode() {
    WhatsAppScreen {

    }
}

@Preview(fontScale = 2f)
@Composable
fun WhatsAppPreviewFontScale() {
    WhatsAppScreen {

    }
}