package id.aditya.pokedex.presentation.home.components

import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.navigation.NavController
import id.aditya.pokedex.R
import id.aditya.pokedex.compose.Dimens
import id.aditya.pokedex.domain.model.remote.Menu
import id.aditya.pokedex.presentation.Screen

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun Menus(navController: NavController, searchText: TextFieldValue) {
    val menuList = getMenuList()
    var filteredMenu: ArrayList<Menu>
    val context = LocalContext.current
    val lightSeal = Color(0xFF02B7BB)
    LazyVerticalGrid(columns = GridCells.Fixed(2), userScrollEnabled = false) {
        filteredMenu = if (searchText.text.isEmpty()) {
            menuList
        } else {
            val resultList = ArrayList<Menu>()
            for (menu in menuList) {
                if (menu.label.lowercase()
                        .contains(searchText.text.lowercase())
                ) {
                    resultList.add(menu)
                }
            }
            resultList
        }

        items(filteredMenu.size) { index ->
            Card(
                modifier = Modifier
                    .padding(Dimens.PaddingSmall)
                    .fillMaxWidth(),
                shape = RoundedCornerShape(Dimens.PaddingNormal),
                onClick = { onClickMenu(context, filteredMenu[index].label, navController) }
            ) {
                Box(
                    modifier = Modifier.background(
                        brush = Brush.linearGradient(
                            colors = filteredMenu[index].color ?: listOf(lightSeal, lightSeal),
                            start = Offset(0f, Float.POSITIVE_INFINITY),
                            end = Offset(Float.POSITIVE_INFINITY, 0f)
                        )
                    )
                ) {
                    ConstraintLayout(modifier = Modifier.fillMaxSize()) {
                        val (image, boxText) = createRefs()
                        Image(
                            modifier = Modifier
                                .constrainAs(image) {
                                    end.linkTo(parent.end)
                                    top.linkTo(parent.top)
                                }
                                .width(30.dp)
                                .height(30.dp)
                                .graphicsLayer {
                                    rotationZ=15F
                                },
                            painter = painterResource(id = R.drawable.ic_poke_white),
                            contentDescription = "just Pokemon",
                            contentScale = ContentScale.Crop
                        )

                        Box(modifier = Modifier.constrainAs(boxText) {
                            start.linkTo(parent.start)
                            end.linkTo(parent.end)
                        }) {
                            Text(
                                text = filteredMenu[index].label,
                                textAlign = TextAlign.Center,
                                modifier = Modifier.padding(Dimens.PaddingLarge),
                                color = Color.White,
                                fontFamily = Dimens.FontFamily
                            )
                        }

                    }

                }

            }

        }


    }
}

private fun getMenuList(): ArrayList<Menu> {
    val menus = arrayListOf<Menu>()
    val red = Color(0xFFFF0000)
    val white = Color(0xFFD9AFD9)
    val pokemonColor = listOf<Color>(
        red,
        white
    )
    menus.add(Menu("Pokedex"))
    menus.add(Menu("Pokemon", pokemonColor))
    menus.add(Menu("Moves"))
    menus.add(Menu("Abilities"))
    menus.add(Menu("Items"))
    menus.add(Menu("Locations"))
    menus.add(Menu("Type Charts"))
    menus.add(Menu("Berries"))
    menus.add(Menu("Version"))
    return menus
}

private fun onClickMenu(context: Context, menu: String, navController: NavController) {
    navController.navigate(Screen.PokemonListScreen.route)
    Toast.makeText(context, menu, Toast.LENGTH_SHORT).show()
}