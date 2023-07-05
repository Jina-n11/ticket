package com.jinana11.ticket.screens.home_screen

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable


private const val ROUTE = "homeScreen"

fun NavController.navigateToHomeScreen(){
    navigate(ROUTE)
}

fun NavGraphBuilder.homeRoute(navController: NavController) {
    composable(ROUTE) {
        HomeScreen(navController)
    }
}
