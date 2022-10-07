package id.aditya.pokedex.domain.repository

import id.aditya.pokedex.domain.model.remote.PokemonListDto

interface PokemonListRepository {
    suspend fun getPokemonList(): PokemonListDto
}