package com.jinana11.ticket.screens.details_screen

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable


private const val ROUTE = "detailsScreen"

fun NavController.navigateToDetailsScreen(){
    navigate(ROUTE)
}

fun NavGraphBuilder.detailsRoute(navController: NavController) {
    composable(ROUTE) {
        DetailsScreen(navController)
    }
}
