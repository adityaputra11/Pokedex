package id.aditya.pokedex.presentation

sealed class Screen(val route: String){
    object HomeScreen:Screen("home_screen")
    object PokemonListScreen:Screen("pokemon_list_screen")
    object PokemonDetailScreen:Screen("pokemon_detail_screen")
}
