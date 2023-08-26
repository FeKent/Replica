package com.example.replica.composables

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Button
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.replica.R

@Composable
fun YnabScreen() {
    Column(modifier = Modifier.fillMaxSize()) {
        Spacer(modifier = Modifier.size(20.dp))
        Text(
            text = "$0.00",
            color = Color(135, 187, 70, 255),
            textAlign = TextAlign.End,
            fontSize = 40.sp,
            fontWeight = FontWeight.Light,
            modifier = Modifier
                .height(300.dp)
                .fillMaxWidth()
                .wrapContentSize(align = Alignment.CenterEnd)
                .padding(end = 8.dp)

        )
        Divider(color = Color.LightGray)
        Spacer(modifier = Modifier.size(5.dp))
        Column {

            Row {
                Image(
                    painter = painterResource(R.drawable.arrow_compare),
                    contentDescription = "Comparison Arrows",
                    modifier = Modifier.align(Alignment.CenterVertically)
                )
                Spacer(modifier = Modifier.size(5.dp))
                Column {
                    Row {
                        Text(text = "From")
                        Spacer(modifier = Modifier.size(20.dp))
                        Text(text = "Ready to Assign")
                        Spacer(modifier = Modifier.size(5.dp))
                        Text(text = "$1230.23")
                    }
                    Spacer(modifier = Modifier.size(5.dp))
                    Divider(color = Color.LightGray)
                    Spacer(modifier = Modifier.size(5.dp))
                    Row {
                        Text(text = "To")
                        Spacer(modifier = Modifier.size(20.dp))
                        Text(text = "Uncat Transactions")
                        Spacer(modifier = Modifier.size(5.dp))
                        Text(text = "$50")
                    }
                }

            }
            Spacer(modifier = Modifier.size(5.dp))
            Divider(color = Color.LightGray)
            Spacer(modifier = Modifier.size(20.dp))
            NumberPad()
        }
    }
}

@Composable
fun NumberPad() {
    Column(
        modifier = Modifier
            .width(250.dp)
            .padding(start = 20.dp)
    ) {
        Row {
            Text(text = "7", modifier = Modifier.weight(0.5f))
            Text(text = "8", modifier = Modifier.weight(0.5f))
            Text(text = "9", modifier = Modifier.weight(0.5f))
        }
        Row {
            Text(text = "4", modifier = Modifier.weight(0.5f))
            Text(text = "5", modifier = Modifier.weight(0.5f))
            Text(text = "6", modifier = Modifier.weight(0.5f))
        }
        Row {
            Text(text = "1", modifier = Modifier.weight(0.5f))
            Text(text = "2", modifier = Modifier.weight(0.5f))
            Text(text = "3", modifier = Modifier.weight(0.5f))
        }
        Row {
            Text(text = "", modifier = Modifier.weight(0.5f))
            Text(text = "0", modifier = Modifier.width(130.dp))
            Image(
                painter = painterResource(R.drawable.backspace),
                alignment = Alignment.BottomStart,
                contentDescription = "Backspace Button",
                modifier = Modifier
                    .size(20.dp)
                    .weight(0.5f)
                    .clickable { /*Todo*/ }

            )
            Button(onClick = { /*TODO*/ }) {
                Text(text = "Done")
            }
        }

    }
}