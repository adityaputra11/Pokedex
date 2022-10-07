package id.aditya.pokedex.domain.model.remote

import androidx.compose.ui.graphics.Color

data class Menu(
    val label:String,
    val color: List<Color>?=null,
    val navigate:String?=null
)
