package id.aditya.pokedex.presentation.pokemon_list

import id.aditya.pokedex.data.remote.PokemonListDto

data class PokemonListState(
    val isLoading:Boolean = false,
    val pokemon: PokemonListDto? = null,
    val error:String = ""
)
