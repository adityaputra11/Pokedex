package id.aditya.pokedex.api

import id.aditya.pokedex.domain.model.remote.PokemonListDto
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

interface PokedexService {

    @GET("pokemon/")
    suspend fun getPokemonList(
        @Query("offset") offset: Number,
        @Query("limit") limit: Number,
    ): PokemonListDto

    companion object{
        private const val BASE_URL = "https://pokeapi.co/api/v2/"

        fun create(): PokedexService {
            val logger = HttpLoggingInterceptor().apply { level = HttpLoggingInterceptor.Level.BASIC }
            val client = OkHttpClient.Builder()
                .addInterceptor(logger)
                .build()
            return Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(PokedexService::class.java)
        }
    }

}