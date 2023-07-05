package com.jinana11.ticket.screens.details_screen

data class ActorUiState(
    val actors: List<Actor> = emptyList()
){
    data class Actor(
        val id: Int ,
        val image: String,
    )
}
