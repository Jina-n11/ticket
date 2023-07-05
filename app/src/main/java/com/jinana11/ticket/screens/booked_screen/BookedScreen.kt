package com.jinana11.ticket.screens.booked_screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Black
import androidx.compose.ui.graphics.Color.Companion.DarkGray
import androidx.compose.ui.graphics.Color.Companion.LightGray
import androidx.compose.ui.graphics.Color.Companion.Transparent
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.jinana11.ticket.R
import com.jinana11.ticket.screens.spacer.horizontal.SpacerHorizontal16
import com.jinana11.ticket.screens.spacer.horizontal.SpacerHorizontal4
import com.jinana11.ticket.screens.spacer.horizontal.SpacerHorizontal8
import com.jinana11.ticket.screens.spacer.vertical.SpacerVertical16
import com.jinana11.ticket.screens.spacer.vertical.SpacerVertical8
import com.jinana11.ticket.ui.theme.LightOnBackground38
import com.jinana11.ticket.ui.theme.LightOnBackground60
import com.jinana11.ticket.ui.theme.LightOnBackground87
import com.jinana11.ticket.ui.theme.LightOnBackgroundL38
import com.jinana11.ticket.ui.theme.LightOnBackgroundL60
import com.jinana11.ticket.ui.theme.primary

@Composable
fun BookedScreen(
    navController: NavController
) {
    Box(modifier = Modifier
        .fillMaxSize()
        .background(Color.White)) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(500.dp)
                .background(Black)
                .padding(bottom = 64.dp).align(Alignment.TopCenter),

        ) {
            Image(
                modifier = Modifier
                    .fillMaxWidth()
                    .align(Alignment.TopCenter)
                    .padding(bottom = 24.dp),
                painter = painterResource(id = R.drawable.booked),
                contentDescription = "",
                contentScale = ContentScale.FillWidth
            )
            Image(
                modifier = Modifier
                    .align(Alignment.TopStart)
                    .padding(16.dp),
                painter = painterResource(id = R.drawable.ic_close),
                contentDescription = "",
                contentScale = ContentScale.FillWidth
            )

            Row(
                horizontalArrangement = Arrangement.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .align(Alignment.BottomCenter)
            ) {
                BookedOff(Color.White, "Available")
                SpacerHorizontal16()
                BookedOff(LightOnBackgroundL60, "Taken")
                SpacerHorizontal16()
                BookedOff(primary, "Selected")
            }
        }

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .clip(
                    RoundedCornerShape(
                        topEnd = 35.dp, topStart = 35.dp
                    )
                )
                .background(color = Color.White)
                .padding(top = 24.dp, start = 24.dp, end = 24.dp, bottom = 8.dp)
                .height(200.dp)
                .align(Alignment.BottomCenter),
            horizontalAlignment = Alignment.CenterHorizontally

        ) {


            LazyRow(
                horizontalArrangement = Arrangement.Center,
                modifier = Modifier.fillMaxWidth()
            ) {
                items(8) {
                    TextChipDay(
                        text = "14",
                        day = "Thu",
                        selectedColor = Color.Red,
                        onChecked = {},
                        isSelected = false,
                    )
                    SpacerHorizontal4()
                }
            }

            SpacerVertical16()


            LazyRow() {
                items(8) {
                    TextChip(
                        text = "10:00",
                        selectedColor = Color.Red,
                        onChecked = {},
                        isSelected = false
                    )
                    SpacerHorizontal4()
                }
            }

            SpacerVertical16()
            SpacerVertical16()

            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier.fillMaxWidth()
            ) {
                Present(title = "$100.00", description = "4 tickets")
                ButtonWithIcon("Buy tickets", R.drawable.ic_card)
            }

        }
    }
}

@Preview
@Composable
fun BookedScreenPreview() {
//    BookedScreen()
}

@Composable
fun Present(title: String, description: String) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Text(
            text = title,
            style = MaterialTheme.typography.headlineSmall,
            color = LightOnBackground87
        )
        SpacerHorizontal4()
        Text(
            text = description,
            style = MaterialTheme.typography.bodySmall,
            color = LightOnBackground38
        )
    }
}


@Composable
fun BookedOff(color: Color, description: String) {
    Row(
        modifier = Modifier.background(Color.Black)
    ) {
        Box(
            modifier = Modifier
                .size(12.dp)
                .clip(CircleShape)
                .background(color)
        )

        SpacerHorizontal8()
        Text(
            text = description,
            style = MaterialTheme.typography.bodySmall,
            color = LightOnBackgroundL60
        )
    }
}


@Composable
fun TextChip(
    isSelected: Boolean,
    text: String,
    onChecked: (Boolean) -> Unit,
    selectedColor: Color = DarkGray
) {
    val shape = CircleShape
    Row(
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .border(
                width = 1.dp,
                color = if (isSelected) selectedColor else LightGray,
                shape = shape
            )
            .background(
                color = if (isSelected) selectedColor else Transparent,
                shape = shape
            )
            .clip(shape = shape)
            .clickable {
                onChecked(!isSelected)
            }
            .padding(
                vertical = 8.dp,
                horizontal = 16.dp
            )
    ) {
        Text(
            text = text.toString(),
            style = MaterialTheme.typography.bodySmall,
            color = LightOnBackground60,
        )
    }
}


@Composable
fun TextChipDay(
    isSelected: Boolean,
    text: String,
    day: String,
    onChecked: (Boolean) -> Unit,
    selectedColor: Color = DarkGray
) {
    val shape = CircleShape
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .border(
                width = 1.dp,
                color = if (isSelected) selectedColor else LightGray,
                shape = shape
            )
            .background(
                color = if (isSelected) selectedColor else Transparent,
                shape = shape
            )
            .clip(shape = shape)
            .clickable {
                onChecked(!isSelected)
            }
            .padding(
                vertical = 8.dp,
                horizontal = 16.dp
            )
    ) {
        Text(
            text = text,
            style = MaterialTheme.typography.bodyLarge,
            color = LightOnBackground87,
        )
        Text(
            text = day,
            style = MaterialTheme.typography.bodySmall,
            color = LightOnBackground60,
        )
    }
}


@Composable
fun ButtonWithIcon(text: String, iconId: Int) {
    Button(onClick = {}, colors = ButtonDefaults.buttonColors(primary)) {
        Image(
            painterResource(id = iconId),
            contentDescription = text,
            modifier = Modifier.size(30.dp),
        )

        Text(
            text = text,
            Modifier.padding(start = 10.dp),
            style = MaterialTheme.typography.bodyLarge
        )
    }
}