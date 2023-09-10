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
import androidx.compose.foundation.layout.wrapContentHeight
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
import java.time.Clock
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.ZoneOffset
import java.time.format.DateTimeFormatter
import java.time.format.TextStyle
import java.util.Locale

sealed interface WhatsAppListEntry

data class MessageState(
    val text: String,
    val dateTime: LocalDateTime,
    val incoming: Boolean,
) : WhatsAppListEntry

data class HeaderState(val title: String) : WhatsAppListEntry

val sampleMessageStates = listOf(
    MessageState(
        text = "The false moustache! Quelle Horreur! Never, in the whole of London, have I seen a pair of moustaches to equal mine.",
        dateTime = LocalDateTime.of(2023, 9, 8, 10, 3),
        incoming = true,
    ),
    MessageState(
        text = "Oh, Mr. Poirot, remember, it's not the size of the moustache that matters, but the sharpness of the mind behind it.",
        dateTime = LocalDateTime.of(2023, 9, 8, 10, 5),
        incoming = false,
    ),
    MessageState(
        text = "Ah, Miss Marple, your wisdom always shines brighter than the most polished waxed tips. Indeed, it is the little grey cells that truly distinguish a detective, not the follicular extravagance.",
        dateTime = LocalDateTime.of(2023, 9, 8, 10, 8),
        incoming = true,
    ),
    MessageState(
        text = "Quite right, Mr. Poirot. Just as a well-trimmed garden reveals hidden beauty, so does a keen intellect uncover the truth amidst the thickest of mysteries.",
        dateTime = LocalDateTime.of(2023, 9, 8, 10, 13),
        incoming = false,
    ),
    MessageState(
        text = "My dear Miss Marple, a perplexing case has crossed my path. The disappearance of Lady Fotherington's priceless pearls leaves me intrigued.",
        dateTime = LocalDateTime.of(2023, 9, 9, 8, 23),
        incoming = true,
    ),
    MessageState(
        text = "Ah, Mr. Poirot, pearls may be lustrous, but they can also hide secrets within their layers. Remember, it's often the most unassuming oyster that holds the key.",
        dateTime = LocalDateTime.of(2023, 9, 9, 8, 48),
        incoming = false,
    ),
    MessageState(
        text = "Très vrai, Miss Marple. Just as a diamond's facets reflect light, so must we examine every angle to reveal the hidden facets of truth.",
        dateTime = LocalDateTime.of(2023, 9, 9, 8, 57),
        incoming = true,
    ),
    MessageState(
        text = "The parallels in our methods never cease to amaze me, Miss Marple. In pearls and puzzles alike, it is the patience and precision that lead to revelations.",
        dateTime = LocalDateTime.of(2023, 9, 9, 8, 59),
        incoming = true,
    ),
    MessageState(
        text = "Patience, precision, and a touch of empathy, Mr. Poirot. Just as threads bind a tapestry, our qualities entwine to solve even the most intricate enigmas.",
        dateTime = LocalDateTime.of(2023, 9, 9, 9, 2),
        incoming = false,
    ),
)

private val sampleClock =
    Clock.fixed(LocalDateTime.of(2023, 9, 9, 11, 6).toInstant(ZoneOffset.UTC), ZoneOffset.UTC)

@Composable
fun WhatsAppScreen(
    // Accept (as a parameter) the data that we need to populate this screen.
    // It's good to practice defining the classes needed to represent this state
    // while building the UI!
    messageStates: List<MessageState> = sampleMessageStates,
    backHome: () -> Unit,
) {
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
            // Only need a single Column here; the nested one wasn't necessary!
            Column(
                // No need for weight here; we want this column to be as big as it needs to be!
                modifier = Modifier
                    .weight(1f)
                    .verticalScroll(rememberScrollState())
            ) {
                // Insert Header states into list (this would happen in a ViewModel, IRL):

                val extendedList = mutableListOf<WhatsAppListEntry>()

                messageStates
                    .groupBy { message -> message.dateTime.toLocalDate() }
                    .toSortedMap()
                    .forEach { (date, messages) ->
                        val dateString =
                            if (date.isEqual(LocalDate.now(sampleClock))) {
                                "Today"
                            } else {
                                date.dayOfWeek.getDisplayName(
                                    TextStyle.FULL_STANDALONE,
                                    Locale.getDefault(),
                                )
                            }

                        extendedList.add(HeaderState(title = dateString))
                        extendedList.addAll(messages)
                    }

                // Draw the items in the newly-extended list (this mostly belongs in the Composable;
                // formatting the time using the date formatter could also happen in the ViewModel
                // and be passed as part of the MessageState):

                for (state in extendedList) {
                    when (state) {
                        is HeaderState -> TimeStamp(date = state.title)
                        is MessageState -> {
                            val timeString = state.dateTime.format(DateTimeFormatter.ofPattern("h:mm"))
                            if (state.incoming) {
                                IncomingMessage(message = state.text, time = timeString)
                            } else {
                                OutgoingMessage(message = state.text, time = timeString)
                            }
                        }
                    }
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
    // In general, it is a good practice to only have 1 root-level Composable.
    // Otherwise, the Composable that calls this one can influence how it looks!
    // For example, if we called the original NewMessage inside a Row, the first Spacer would create
    // horizontal space; if we called NewMessage inside a Column, the first Spacer would create
    // vertical space! :S
    Column(modifier = Modifier.wrapContentHeight()) {
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
                "Voice Message",
                tint = Color.White,
                modifier = Modifier
                    .align(Alignment.CenterVertically)
                    .background(color = Color(0, 168, 132, 255), shape = CircleShape)
                    .padding(10.dp)
            )
        }
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
    Column {
        Row(
            modifier = Modifier
                .padding(start = 8.dp, end = 55.dp)
        ) {
            Box(
                modifier = Modifier
                    .background(color = Color.White, shape = RoundedCornerShape(5.dp))
                    .padding(8.dp, bottom = 4.dp)
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
                        Spacer(modifier = Modifier.size(4.dp))
                    }
                }
            }
        }
        Spacer(modifier = Modifier.size(8.dp))
    }
}

@Composable
fun OutgoingMessage(message: String, time: String) {
    Column {
        Row(
            modifier = Modifier
                .padding(start = 55.dp, end = 8.dp)
        ) {
            Box(
                modifier = Modifier
                    .background(color = Color(231, 255, 219, 255), shape = RoundedCornerShape(5.dp))
                    .padding(8.dp, bottom = 4.dp)
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
                        Spacer(modifier = Modifier.size(4.dp))
                    }
                }
            }
        }
        Spacer(modifier = Modifier.size(8.dp))
    }
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

// Previews

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

// Add a new preview to see what the screen looks like with no messages
// (Verifies that the message editing UI is still correctly placed at the bottom of the screen)
@Preview
@Composable
fun WhatsAppPreviewEmptyChat() {
    WhatsAppScreen(messageStates = emptyList()) {

    }
}

// Add a new preview to see what the screen looks like with a small number of messages.
@Preview
@Composable
fun WhatsAppPreviewShortChat() {
    WhatsAppScreen(
        messageStates = listOf(
            MessageState(
                text = "Hello, world!",
                dateTime = LocalDateTime.of(2024, 1, 12, 14, 59, 59),
                incoming = true,
            )
        )
    ) {

    }
}
