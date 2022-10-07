package id.aditya.pokedex.domain.use_case.get_pokemon_list

import id.aditya.pokedex.common.Resource
import id.aditya.pokedex.domain.model.remote.PokemonListDto
import id.aditya.pokedex.domain.repository.PokemonListRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetPokemonListUseCase @Inject constructor(
    private val repository: PokemonListRepository
) {
    operator fun invoke(): Flow<Resource<PokemonListDto>> = flow {
        try {
            emit(Resource.Loading<PokemonListDto>())
            val pokemons = repository.getPokemonList()
            emit(Resource.Success<PokemonListDto>(pokemons))
        } catch (exception: HttpException) {
            emit(
                Resource.Error<PokemonListDto>(
                    exception.localizedMessage ?: "An unexpected error occurred"
                )
            )
        } catch (exception: IOException) {
            emit(Resource.Error<PokemonListDto>(
                "Couldn't reach server. Check your internet connection"
            ))
        }
    }
}