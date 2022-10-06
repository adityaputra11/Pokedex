package id.aditya.pokedex.di


import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import id.aditya.pokedex.api.PokedexService
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class NetworkModule {

    @Singleton
    @Provides
    fun providePokedexServices(): PokedexService {
        return PokedexService.create()
    }
}