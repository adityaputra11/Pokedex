package id.aditya.pokedex.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navDeepLink
import dagger.hilt.android.AndroidEntryPoint
import id.aditya.pokedex.presentation.home.HomeScreen
import id.aditya.pokedex.presentation.pokemon_detail.PokemonDetailScreen
import id.aditya.pokedex.presentation.pokemon_list.PokemonListScreen
import id.aditya.pokedex.presentation.ui.theme.PokedexTheme

private val uri = "https://www.pokedexdit.com"


@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            PokedexTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    val navController = rememberNavController()
                    NavHost(
                        navController = navController,
                        startDestination = Screen.HomeScreen.route
                    ) {
                        composable(route = Screen.HomeScreen.route) {
                            HomeScreen(navController)
                        }
                        composable(route = Screen.PokemonListScreen.route) {
                            PokemonListScreen(navController)
                        }
                        composable(
                            route = Screen.PokemonDetailScreen.route + "/{menu}",
                            deepLinks = listOf(
                                navDeepLink { uriPattern = "$uri/detail/{menu}" })
                        ) {
                            val menu = it.arguments?.getString("menu")
                            PokemonDetailScreen(menu)
                        }
                    }
                }
            }
        }
    }
}


@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    PokedexTheme {
        Greeting("Android")
    }
}