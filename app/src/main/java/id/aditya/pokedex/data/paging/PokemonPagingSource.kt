package id.aditya.pokedex.data.paging

import androidx.paging.PagingSource
import androidx.paging.PagingState
import id.aditya.pokedex.api.PokedexService
import id.aditya.pokedex.data.remote.Result

private const val POKEMON_OFFSET = 20
class PokemonPagingSource(private val pokedexService: PokedexService): PagingSource<Int, Result>() {
    override fun getRefreshKey(state: PagingState<Int, Result>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            // This loads starting from previous page, but since PagingConfig.initialLoadSize spans
            // multiple pages, the initial load will still load items centered around
            // anchorPosition. This also prevents needing to immediately launch prepend due to
            // prefetchDistance.
            state.closestPageToPosition(anchorPosition)?.prevKey
        }
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Result> {
       val offset = params.key?: POKEMON_OFFSET
        return try {
            val respose = pokedexService.getPokemonList(offset, params.loadSize)
            val pokemons = respose.results
            LoadResult.Page(
                data = pokemons,
                prevKey = if(offset == POKEMON_OFFSET) null else offset - 20,
                nextKey = offset + 20
            )
        }catch (exception:Exception){
            LoadResult.Error(exception)
        }
    }


}