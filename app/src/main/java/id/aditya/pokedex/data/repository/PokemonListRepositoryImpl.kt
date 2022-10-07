package id.aditya.pokedex.data.repository

import id.aditya.pokedex.api.PokedexService
import id.aditya.pokedex.domain.model.remote.PokemonListDto
import id.aditya.pokedex.domain.repository.PokemonListRepository
import javax.inject.Inject

class PokemonListRepositoryImpl @Inject constructor(
    private val pokemonService: PokedexService
) : PokemonListRepository {

    override suspend fun getPokemonList(): PokemonListDto {
       return pokemonService.getPokemonList(OFFSET, LIMIT)
    }
    companion object {
        private const val LIMIT = 20
        private const val OFFSET = 0
    }
}