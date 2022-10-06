package id.aditya.pokedex.data.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import id.aditya.pokedex.api.PokedexService
import id.aditya.pokedex.data.paging.PokemonPagingSource
import id.aditya.pokedex.data.remote.PokemonListDto
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class PokemonListRepositoryImpl @Inject constructor(
    private val pokemonService: PokedexService
) : PokemonListRepository {

    override suspend fun getPokemonList(): PokemonListDto {
       return pokemonService.getPokemonList(0,20)
    }
    companion object {
        private const val NETWORK_PAGE_SIZE = 25
    }
}