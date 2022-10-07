package id.aditya.pokedex.domain.model.remote

data class PokemonListDto(
    val count: Int,
    val next: String,
    val previous: Any,
    val results: List<Result>
)