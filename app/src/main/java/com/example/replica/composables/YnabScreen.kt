@file:OptIn(ExperimentalMaterial3Api::class)

package com.example.replica.composables

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
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
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material3.Button
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.replica.R

data class YnabScreenViewState(
    val moveAmount: String,
    val fromCategory: String,
    val fromCategoryAmount: String,
    val toCategory: String,
    val toCategoryAmount: String,
)

@Composable
fun YnabScreen(
    backHome: () -> Unit,
    viewState: YnabScreenViewState = YnabScreenViewState(
        moveAmount = "$0.00",
        fromCategory = "Ready to Assign",
        fromCategoryAmount = "$1230.23",
        toCategory = "Uncat Transactions",
        toCategoryAmount = "$50.00",
    ),
) {
    Column(
        modifier = Modifier
            .fillMaxSize(1f)
            .background(Color.White)
    ) {
        ElevatedCenterAlignedTopAppBar(backHome = backHome)
        Spacer(modifier = Modifier.size(16.dp))
        Text(
            text = viewState.moveAmount,
            color = Color(135, 187, 70, 255),
            textAlign = TextAlign.End,
            fontSize = 60.sp,
            fontWeight = FontWeight.Light,
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
                .wrapContentSize(align = Alignment.CenterEnd)
                .padding(end = 8.dp)

        )
        Divider()
        Spacer(modifier = Modifier.size(4.dp))
        Column(modifier = Modifier.fillMaxWidth()) {
            Row {
                Image(
                    painter = painterResource(R.drawable.compare_arrows),
                    contentDescription = "Comparison Arrows",
                    modifier = Modifier
                        .align(Alignment.CenterVertically)
                        .size(40.dp)
                        .padding(start = 8.dp)
                        .clickable { /*TODO*/ }
                )
                Spacer(modifier = Modifier.size(16.dp))
                Column {
                    CategoryRow(
                        label = "From:",
                        category = viewState.fromCategory,
                        categoryAmount = viewState.fromCategoryAmount
                    )
                    Spacer(modifier = Modifier.size(4.dp))
                    Divider()
                    Spacer(modifier = Modifier.size(4.dp))
                    CategoryRow(
                        label = "To:",
                        category = viewState.toCategory,
                        categoryAmount = viewState.toCategoryAmount
                    )
                }
            }
            Spacer(modifier = Modifier.size(4.dp))
            Divider()
            Spacer(modifier = Modifier.size(16.dp))
            NumberPad()
            Spacer(modifier = Modifier.size(16.dp))
            Divider()
        }
    }
}

@Composable
fun CategoryRow(label: String, category: String, categoryAmount: String) {
    Row(modifier = Modifier.padding(vertical = 8.dp)) {
        Text(text = label, color = Color.Gray, fontWeight = FontWeight.Medium)
        Row(
            horizontalArrangement = Arrangement.End,
            modifier = Modifier.fillMaxWidth()
        ) {
            Spacer(modifier = Modifier.size(16.dp))
            Text(text = category, fontWeight = FontWeight.Bold)
            Spacer(modifier = Modifier.size(4.dp))
            Text(text = categoryAmount, color = Color(0, 102, 139))
            Icon(
                Icons.Filled.KeyboardArrowRight,
                contentDescription = "Arrow Right",
                tint = Color.Gray
            )
        }

    }
}

@Composable
fun NumberPad() {
    Box {
        Column(
            modifier = Modifier
                .width(400.dp)
                .padding(horizontal = 60.dp)
        ) {
            Row {
                Text(
                    text = "7",
                    fontSize = 20.sp,
                    color = Color.DarkGray,
                    modifier = Modifier.weight(0.5f)
                )
                Text(
                    text = "8",
                    fontSize = 20.sp,
                    color = Color.DarkGray,
                    modifier = Modifier.weight(0.5f)
                )
                Text(
                    text = "9",
                    fontSize = 20.sp,
                    color = Color.DarkGray,
                    modifier = Modifier.weight(0.5f)
                )
            }
            Spacer(modifier = Modifier.size(8.dp))
            Row {
                Text(
                    text = "4",
                    fontSize = 20.sp,
                    color = Color.DarkGray,
                    modifier = Modifier.weight(0.5f)
                )
                Text(
                    text = "5",
                    fontSize = 20.sp,
                    color = Color.DarkGray,
                    modifier = Modifier.weight(0.5f)
                )
                Text(
                    text = "6",
                    fontSize = 20.sp,
                    color = Color.DarkGray,
                    modifier = Modifier.weight(0.5f)
                )
            }
            Spacer(modifier = Modifier.size(8.dp))
            Row {
                Text(
                    text = "1",
                    fontSize = 20.sp,
                    color = Color.DarkGray,
                    modifier = Modifier.weight(0.5f)
                )
                Text(
                    text = "2",
                    fontSize = 20.sp,
                    color = Color.DarkGray,
                    modifier = Modifier.weight(0.5f)
                )
                Text(
                    text = "3",
                    fontSize = 20.sp,
                    color = Color.DarkGray,
                    modifier = Modifier.weight(0.5f)
                )
            }
            Spacer(modifier = Modifier.size(8.dp))
            Row {
                Text(text = "", fontSize = 20.sp, modifier = Modifier.weight(0.25f))
                Text(
                    text = "0",
                    fontSize = 20.sp,
                    color = Color.DarkGray,
                    modifier = Modifier.weight(0.25f)
                )
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

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ElevatedCenterAlignedTopAppBar(backHome: () -> Unit) {
    Surface(shadowElevation = 6.dp, modifier = Modifier.fillMaxWidth()) {
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
                IconButton({}) {
                    Icon(Icons.Filled.Close, "Close", tint = Color(0, 102, 139), modifier = Modifier
                        .clickable { backHome() }
                    )
                }
            })
    }
}

@Preview()
@Composable
private fun PreviewLight() {
    YnabScreen({})
}

@Preview()
@Composable
private fun PreviewLongStrings() {
    YnabScreen(
        {},
        viewState = YnabScreenViewState(
            moveAmount = "$1,000,000,000,000,000.00",
            fromCategory = "🙌 This is my favorite category so I described it with lots of words",
            fromCategoryAmount = "$1,230.23",
            toCategory = "Short cat",
            toCategoryAmount = "$500,000,000,000,000,000,000,000,000,000.00",
        )
    )
}
