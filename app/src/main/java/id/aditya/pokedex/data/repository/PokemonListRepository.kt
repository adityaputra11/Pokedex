package id.aditya.pokedex.data.repository

import id.aditya.pokedex.data.remote.PokemonListDto

interface PokemonListRepository {
    suspend fun getPokemonList(): PokemonListDto
}