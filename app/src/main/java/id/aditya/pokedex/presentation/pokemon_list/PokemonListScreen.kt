package id.aditya.pokedex.presentation.pokemon_list

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.bumptech.glide.Glide
import com.skydoves.landscapist.ImageOptions
import com.skydoves.landscapist.glide.GlideImage
import id.aditya.pokedex.compose.Dimens
import id.aditya.pokedex.presentation.pokemon_list.components.Header
import id.aditya.pokedex.viewmodels.PokemonListViewModel

@Composable
fun PokemonListScreen(
//    navController: NavController,
    viewModel: PokemonListViewModel = hiltViewModel()
) {
    val state by viewModel.pokemonListData.observeAsState()
    val result = state?.results
    var searchText by rememberSaveable(stateSaver = TextFieldValue.Saver) {
        mutableStateOf(
            TextFieldValue()
        )
    }
    Column(modifier = Modifier.padding(Dimens.PaddingSmall)) {
        Header(searchText, onSearchMenu = { searchText = it })
        LazyColumn {
            item {
                Text(text = "PokemonListScreen")
            }
            if (result?.isNotEmpty() == true) {
                items(result.size) { index ->
                    Card(
                        modifier = Modifier
                            .padding(
                                Dimens.PaddingSmall,
                            )
                            .fillMaxWidth(),
                        backgroundColor = Color.DarkGray,
                        shape = RoundedCornerShape(Dimens.PaddingLarge)
                    ) {
                        Column(
                            modifier = Modifier
                                .padding(Dimens.PaddingLarge)
                        ) {
                            Row(
                                verticalAlignment = Alignment.CenterVertically,
                            ) {
                                GlideImage(
                                    modifier = Modifier
                                        .width(100.dp)
                                        .height(100.dp),
                                    imageModel = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/${index + 1}.png",
                                    imageOptions = ImageOptions(
                                        contentScale = ContentScale.Crop,
                                    ),
                                    loading = {
                                        CircularProgressIndicator()
                                    }
                                )
                                Text(
                                    text = result[index].name,
                                    fontSize = Dimens.TextMedium,
                                    color = Color.White
                                )
                            }

                        }

                    }

                }
            }
        }
    }

}
