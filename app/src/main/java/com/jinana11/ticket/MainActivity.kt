package com.jinana11.ticket

import android.os.Bundle
import android.telecom.Call.Details
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import com.jinana11.ticket.screens.TicketNavGraph
import com.jinana11.ticket.screens.booked_screen.BookedScreen
import com.jinana11.ticket.screens.details_screen.DetailsScreen
import com.jinana11.ticket.screens.home_screen.HomeScreen
import com.jinana11.ticket.ui.theme.TicketTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TicketTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val navController = rememberNavController()
                    TicketNavGraph(navController = navController)
//                    HomeScreen()
                }
            }
        }
    }
}