package id.aditya.pokedex.data.remote

import androidx.compose.ui.graphics.Color

data class Menu(
    val label:String,
    val color: Color?=null,
    val navigate:String?=null
)
