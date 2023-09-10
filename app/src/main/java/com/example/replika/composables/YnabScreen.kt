@file:OptIn(ExperimentalMaterial3Api::class)

package com.example.replika.composables

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.graphics.toColorInt
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
                    contentDescription = "Swap categories",
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
                        categoryAmount = viewState.fromCategoryAmount,
                        onClick = {},
                    )
                    Spacer(modifier = Modifier.size(4.dp))
                    Divider()
                    Spacer(modifier = Modifier.size(4.dp))
                    CategoryRow(
                        label = "To:",
                        category = viewState.toCategory,
                        categoryAmount = viewState.toCategoryAmount,
                        onClick = {},
                    )
                }
            }
            Spacer(modifier = Modifier.size(4.dp))
            Divider()
            NumberPad()
        }
    }
}

@Composable
fun CategoryRow(label: String, category: String, categoryAmount: String, onClick: () -> Unit) {
    Row(
        modifier = Modifier
            .clickable(onClick = onClick)
            .padding(vertical = 8.dp)
    ) {
        Text(text = label, color = Color.Gray, fontWeight = FontWeight.Medium)
        Spacer(modifier = Modifier.size(16.dp))
        Text(
            text = category,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.weight(1f),
            textAlign = TextAlign.End
        )
        Spacer(modifier = Modifier.size(4.dp))
        Text(
            text = categoryAmount,
            color = Color(0, 102, 139),
            modifier = Modifier.widthIn(max = 120.dp)
        )
        Icon(
            Icons.Filled.KeyboardArrowRight,
            contentDescription = null,
            tint = Color.Gray
        )
    }
}

@Composable
fun NumberPad() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
    ) {
        NumberPadRow(
            {
                TextButton(
                    {},
                    modifier = Modifier.weight(1f),
                ) {
                    Text(
                        text = "7",
                        fontSize = 20.sp,
                        textAlign = TextAlign.Center
                    )
                }
            },
            {
                TextButton(
                    {},
                    modifier = Modifier.weight(1f),
                ) {
                    Text(
                        text = "8",
                        fontSize = 20.sp,
                        textAlign = TextAlign.Center
                    )
                }
            },
            {
                TextButton(
                    {},
                    modifier = Modifier.weight(1f),
                ) {
                    Text(
                        text = "9",
                        fontSize = 20.sp,
                        textAlign = TextAlign.Center
                    )
                }
            },
            {
                Spacer(modifier = Modifier.weight(1f))
            },
        )
        NumberPadRow(
            {
                TextButton(
                    {},
                    modifier = Modifier.weight(1f),
                ) {
                    Text(
                        text = "4",
                        fontSize = 20.sp,
                        textAlign = TextAlign.Center
                    )
                }
            },
            {
                TextButton(
                    {},
                    modifier = Modifier.weight(1f),
                ) {
                    Text(
                        text = "5",
                        fontSize = 20.sp,
                        textAlign = TextAlign.Center
                    )
                }
            },
            {
                TextButton(
                    {},
                    modifier = Modifier.weight(1f),
                ) {
                    Text(
                        text = "6",
                        fontSize = 20.sp,
                        textAlign = TextAlign.Center
                    )
                }
            },
            {
                Spacer(modifier = Modifier.weight(1f))
            },
        )
        NumberPadRow(
            {
                TextButton(
                    {},
                    modifier = Modifier.weight(1f),
                ) {
                    Text(
                        text = "1",
                        fontSize = 20.sp,
                        textAlign = TextAlign.Center
                    )
                }
            },
            {
                TextButton(
                    {},
                    modifier = Modifier.weight(1f),
                ) {
                    Text(
                        text = "2",
                        fontSize = 20.sp,
                        textAlign = TextAlign.Center
                    )
                }
            },
            {
                TextButton(
                    {},
                    modifier = Modifier.weight(1f),
                ) {
                    Text(
                        text = "3",
                        fontSize = 20.sp,
                        textAlign = TextAlign.Center
                    )
                }
            },
            {
                Spacer(modifier = Modifier.weight(1f))
            },
        )
        NumberPadRow(
            {
                Spacer(modifier = Modifier.weight(1f))
            },
            {
                TextButton(
                    {},
                    modifier = Modifier.weight(1f),
                ) {
                    Text(
                        text = "0",
                        fontSize = 20.sp,
                        textAlign = TextAlign.Center
                    )
                }
            },
            {
                // Bit of a hack, using text button to get clear background:
                TextButton({}, modifier = Modifier.weight(1f)) {
                    Icon(
                        painter = painterResource(R.drawable.backspace),
                        contentDescription = "Backspace",
                        tint = Color("#00668B".toColorInt()),
                        modifier = Modifier
                            .clickable { /*Todo*/ }

                    )
                }
            },
            {
                Button(
                    onClick = { /*TODO*/ },
                    modifier = Modifier.weight(1f),
                    colors = ButtonDefaults.buttonColors(containerColor = Color("#00668B".toColorInt())),
                    shape = RoundedCornerShape(4.dp)
                ) {
                    Text(text = "Done", style = LocalTextStyle.current.copy(color = Color.White))
                }
            }
        )
    }
}

@Composable
fun NumberPadRow(
    col1: @Composable () -> Unit,
    col2: @Composable () -> Unit,
    col3: @Composable () -> Unit,
    col4: @Composable () -> Unit,
    modifier: Modifier = Modifier,
) {
    CompositionLocalProvider(
        LocalTextStyle provides LocalTextStyle.current.copy(color = Color.DarkGray),
    ) {

        Row(
            modifier = modifier.heightIn(min = 48.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            col1()
            col2()
            col3()
            col4()
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
