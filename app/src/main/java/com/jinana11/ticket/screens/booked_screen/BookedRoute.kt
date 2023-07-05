package com.jinana11.ticket.screens.booked_screen

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable


private const val ROUTE = "bookedScreen"

fun NavController.navigateToBookedScreen(){
    navigate(ROUTE)
}

fun NavGraphBuilder.bookedRoute(navController: NavController) {
    composable(ROUTE) {
        BookedScreen(navController)
    }
}
