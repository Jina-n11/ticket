package com.jinana11.ticket.screens.home_screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
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
import androidx.compose.ui.draw.blur
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.DarkGray
import androidx.compose.ui.graphics.Color.Companion.LightGray
import androidx.compose.ui.graphics.Color.Companion.Transparent
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.jinana11.ticket.R
import com.jinana11.ticket.screens.booked_screen.navigateToBookedScreen
import com.jinana11.ticket.screens.details_screen.navigateToDetailsScreen
import com.jinana11.ticket.screens.spacer.horizontal.SpacerHorizontal16
import com.jinana11.ticket.screens.spacer.horizontal.SpacerHorizontal4
import com.jinana11.ticket.screens.spacer.horizontal.SpacerHorizontal8
import com.jinana11.ticket.screens.spacer.vertical.SpacerVertical16
import com.jinana11.ticket.ui.theme.LightOnBackground38
import com.jinana11.ticket.ui.theme.LightOnBackground60
import com.jinana11.ticket.ui.theme.LightOnBackground87
import com.jinana11.ticket.ui.theme.LightOnBackgroundL87
import com.jinana11.ticket.ui.theme.primary

@Composable
fun HomeScreen(
    navController: NavController,
) {
    Box(modifier = Modifier
        .fillMaxSize()
        .background(Color.White)) {
        Box(modifier = Modifier
            .fillMaxWidth()
            .height(460.dp),) {
            Image(
                modifier = Modifier
                    .fillMaxWidth()
                    .align(Alignment.TopCenter)
                    .blur(10.dp),
                painter = painterResource(id = R.drawable.item1),
                contentDescription = "",
                contentScale = ContentScale.FillWidth
            )
            Row(
                horizontalArrangement = Arrangement.SpaceEvenly,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .align(Alignment.TopCenter)
                    .padding(24.dp)
            ) {
                ButtonText(
                    "Now Showing",
                    onChecked = {navController.navigateToBookedScreen()}
                )
                SpacerHorizontal16()
                TextChipWithIcon(
                    text = "Coming Soon",
                    selectedColor = primary,
                    onChecked = {},
                    isSelected = false,
                    colorText = LightOnBackgroundL87,
                )
            }
        }

        SpacerVertical16()

        LazyRow(
            modifier = Modifier.align(Alignment.TopCenter).padding(top = 100.dp)
        ){
            items(3){
                Image(
                    contentScale = ContentScale.Crop,
                    painter = painterResource(id = R.drawable.item1),
                    contentDescription = "",
                    modifier = Modifier.width(260.dp).clickable { navController.navigateToDetailsScreen() }
                )
                SpacerHorizontal16()
            }

        }

        Column(
            modifier = Modifier
                .fillMaxWidth()

                .align(Alignment.BottomCenter)
                .padding(top = 24.dp, start = 24.dp, end = 24.dp, bottom = 8.dp)
                .height(180.dp),
            horizontalAlignment = Alignment.CenterHorizontally

        ) {


            Row(
                horizontalArrangement = Arrangement.SpaceEvenly,
                verticalAlignment = Alignment.CenterVertically,
            ) {

                Image(
                    modifier = Modifier
                        .padding(16.dp),
                    painter = painterResource(id = R.drawable.ic_timer_clock),
                    contentDescription = "",
                    contentScale = ContentScale.FillWidth
                )
                Text(text = "2h 23m")


            }


            Text(
                modifier = Modifier
                    .fillMaxWidth(),
                textAlign = TextAlign.Center,
                text = "Fantastic Beasts: The Secrets of Dumbledore",
                style = MaterialTheme.typography.titleLarge,
                color = LightOnBackground87,
            )

            SpacerVertical16()

            Row(
                horizontalArrangement = Arrangement.Center,
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                TextChipWithIcon(
                    text = "Fantasy",
                    selectedColor = Color.Red,
                    onChecked = {},
                    isSelected = false
                )

                SpacerHorizontal8()

                TextChipWithIcon(
                    text = "Adventure",
                    selectedColor = Color.Red,
                    onChecked = {},
                    isSelected = false
                )
            }

        }
    }
}

@Preview
@Composable
fun HomeScreenPreview() {

}

@Composable
fun Present(title: String, description: String) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = title, style = MaterialTheme.typography.bodyLarge, color = LightOnBackground87)
        SpacerHorizontal4()
        Text(
            text = description,
            style = MaterialTheme.typography.bodySmall,
            color = LightOnBackground38
        )
    }
}




@Composable
fun TextChipWithIcon(
    isSelected: Boolean,
    text: String,
    onChecked: (Boolean) -> Unit,
    selectedColor: Color = DarkGray,
    colorText: Color = LightOnBackground60,
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
            text = text,
            style = MaterialTheme.typography.bodySmall,
            color = colorText,
            )
    }
}




@Composable
fun ButtonText(text:String , onChecked: () -> Unit,) {
    Button( onClick = onChecked, colors = ButtonDefaults.buttonColors(primary)) {

        Text(text = text , style = MaterialTheme.typography.bodySmall )
    }
}