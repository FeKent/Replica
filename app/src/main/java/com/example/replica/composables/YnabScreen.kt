package com.example.replica.composables

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.replica.R

@Composable
fun YnabScreen() {
    Column {
        Spacer(modifier = Modifier.size(20.dp))
        Text(text = "$0.00", textAlign = TextAlign.End, modifier = Modifier
            .height(300.dp)
            .fillMaxWidth())
        Column {

            Row {
                Image(painter = painterResource(R.drawable.arrow_compare), contentDescription = "Comparison Arrows")
                Spacer(modifier = Modifier.size(5.dp))
                Column {
                    Row {
                        Text(text = "From")
                        Spacer(modifier = Modifier.size(20.dp))
                        Text(text = "Ready to Assign")
                        Spacer(modifier = Modifier.size(5.dp))
                        Text(text = "$1230.23")
                    }
                    Row {
                        Text(text = "To")
                        Spacer(modifier = Modifier.size(20.dp))
                        Text(text = "Uncat Transactions")
                        Spacer(modifier = Modifier.size(5.dp))
                        Text(text = "$50")
                    }
                }

            }

        }
    }
}