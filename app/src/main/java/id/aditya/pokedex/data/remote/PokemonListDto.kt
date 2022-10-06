package id.aditya.pokedex.data.remote

data class PokemonListDto(
    val count: Int,
    val next: String,
    val previous: Any,
    val results: List<Result>
)