package com.example.replica.composables

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Button
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.replica.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun YnabScreen() {

    Column(modifier = Modifier.fillMaxSize(1f)) {
        CenterAlignedTopAppBar(
            title = {
                Text(
                    text = "YNAB - Move Money Screen",
                    color = Color(135, 187, 70, 255),
                    fontWeight = FontWeight.SemiBold,
                    fontSize = 20.sp,
                )
            },
            navigationIcon = {
                Image(
                    painter = painterResource(id = R.drawable.menu),
                    contentDescription = "Menu Icon",
                    modifier = Modifier
                        .clickable { /*TODO*/ }
                        .size(40.dp)
                )
            })
        Divider(color = Color.LightGray)
        Spacer(modifier = Modifier.size(16.dp))
        Text(
            text = "$0.00",
            color = Color(135, 187, 70, 255),
            textAlign = TextAlign.End,
            fontSize = 40.sp,
            fontWeight = FontWeight.Light,
            modifier = Modifier
                .fillMaxWidth()
                .weight(2f)
                .wrapContentSize(align = Alignment.CenterEnd)
                .padding(end = 8.dp)

        )
        Divider(color = Color.LightGray)
        Spacer(modifier = Modifier.size(4.dp))
        Column(modifier = Modifier
            .fillMaxWidth()
            .weight(1f)) {
            Row {
                Image(
                    painter = painterResource(R.drawable.arrow_compare),
                    contentDescription = "Comparison Arrows",
                    modifier = Modifier
                        .align(Alignment.CenterVertically)
                        .rotate(90f)
                        .padding(start = 8.dp)
                        .clickable { /*TODO*/ }
                )
                Spacer(modifier = Modifier.size(24.dp))
                Column {
                    Row(modifier = Modifier.padding(vertical = 8.dp)) {
                        Text(text = "From:", color = Color.Gray, fontWeight = FontWeight.Medium)
                        Spacer(modifier = Modifier.size(16.dp))
                        Text(text = "Ready to Assign")
                        Spacer(modifier = Modifier.size(4.dp))
                        Text(text = "$1230.23", color = Color(0, 102, 139))
                    }
                    Spacer(modifier = Modifier.size(4.dp))
                    Divider(color = Color.LightGray)
                    Spacer(modifier = Modifier.size(4.dp))
                    Row(modifier = Modifier.padding(vertical = 8.dp)) {
                        Text(text = "To:", color = Color.Gray, fontWeight = FontWeight.Medium)
                        Spacer(modifier = Modifier.size(16.dp))
                        Text(text = "Uncat Transactions")
                        Spacer(modifier = Modifier.size(4.dp))
                        Text(text = "$50", color = Color(0, 102, 139))
                    }
                }
            }
            Spacer(modifier = Modifier.size(4.dp))
            Divider(color = Color.LightGray)
            Spacer(modifier = Modifier.size(16.dp))
            NumberPad()
            Spacer(modifier = Modifier.size(16.dp))
            Divider(color = Color.LightGray)
        }
    }
}

@Composable
fun NumberPad() {
    Box {
        Column(
            modifier = Modifier
                .width(500.dp)
                .padding(start = 20.dp)
        ) {
            Row {
                Text(text = "7", modifier = Modifier.weight(0.5f))
                Text(text = "8", modifier = Modifier.weight(0.5f))
                Text(text = "9", modifier = Modifier.weight(0.5f))
            }
            Spacer(modifier = Modifier.size(8.dp))
            Row {
                Text(text = "4", modifier = Modifier.weight(0.5f))
                Text(text = "5", modifier = Modifier.weight(0.5f))
                Text(text = "6", modifier = Modifier.weight(0.5f))
            }
            Spacer(modifier = Modifier.size(8.dp))
            Row {
                Text(text = "1", modifier = Modifier.weight(0.5f))
                Text(text = "2", modifier = Modifier.weight(0.5f))
                Text(text = "3", modifier = Modifier.weight(0.5f))
            }
            Spacer(modifier = Modifier.size(8.dp))
            Row {
                Text(text = "", modifier = Modifier.weight(0.25f))
                Text(text = "0", modifier = Modifier.weight(0.25f))
                Image(
                    painter = painterResource(R.drawable.backspace),
                    alignment = Alignment.BottomStart,
                    contentDescription = "Backspace Button",
                    modifier = Modifier
                        .size(20.dp)
                        .weight(0.25f)
                        .clickable { /*Todo*/ }

                )
            }
        }
        Button(onClick = { /*TODO*/ }, modifier = Modifier.align(Alignment.BottomEnd)) {
            Text(text = "Done")
        }
    }

}

