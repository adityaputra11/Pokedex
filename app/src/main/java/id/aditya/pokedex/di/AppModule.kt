package id.aditya.pokedex.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import id.aditya.pokedex.api.PokedexService
import id.aditya.pokedex.data.repository.PokemonListRepository
import id.aditya.pokedex.data.repository.PokemonListRepositoryImpl
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {
    @Provides
    @Singleton
    fun providePokemonListRepository(pokedexService: PokedexService): PokemonListRepository {
        return PokemonListRepositoryImpl(pokedexService)
    }
}