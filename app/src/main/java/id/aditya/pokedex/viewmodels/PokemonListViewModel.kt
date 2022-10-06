package id.aditya.pokedex.viewmodels

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import dagger.hilt.android.lifecycle.HiltViewModel
import id.aditya.pokedex.data.remote.PokemonListDto
import id.aditya.pokedex.data.remote.Result
import id.aditya.pokedex.data.repository.PokemonListRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
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