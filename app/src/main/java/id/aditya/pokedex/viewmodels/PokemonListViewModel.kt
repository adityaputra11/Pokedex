package id.aditya.pokedex.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import id.aditya.pokedex.domain.model.remote.PokemonListDto
import id.aditya.pokedex.domain.repository.PokemonListRepository
import kotlinx.coroutines.launch
import javax.inject.Inject

private const val TAG = "PokemonListViewModel"

@HiltViewModel
class PokemonListViewModel @Inject constructor(
   private val pokemonListRepository: PokemonListRepository
):ViewModel() {
    private val _pokemonListData = MutableLiveData<PokemonListDto>()
    val pokemonListData:LiveData<PokemonListDto> = _pokemonListData

    init {
        viewModelScope.launch {
            _pokemonListData.value = pokemonListRepository.getPokemonList()
        }

    }

    fun getPokemonList(){

    }
}