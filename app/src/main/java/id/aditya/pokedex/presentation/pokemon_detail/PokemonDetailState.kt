package id.aditya.pokedex.presentation.pokemon_detail

data class PokemonDetailState(
    val isLoading:Boolean = false,
    val pokemon:Any? = null,
    val error:String = ""
)
