package com.jinana11.ticket.screens

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.jinana11.ticket.screens.booked_screen.bookedRoute
import com.jinana11.ticket.screens.details_screen.detailsRoute
import com.jinana11.ticket.screens.home_screen.homeRoute

@Composable
fun TicketNavGraph(navController: NavHostController){
    NavHost(navController = navController, startDestination = "homeScreen"){

        homeRoute(navController)
        detailsRoute(navController = navController)
        bookedRoute(navController)
    }

}