package id.aditya.pokedex.presentation.home.components

import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.navigation.NavController
import id.aditya.pokedex.compose.Dimens
import id.aditya.pokedex.data.remote.Menu
import id.aditya.pokedex.presentation.Screen

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun Menus(navController: NavController, searchText: TextFieldValue) {
    val menuList = getMenuList()
    var filteredMenu: ArrayList<Menu>
    val context = LocalContext.current
    val colorGray = Color.DarkGray
//    val colorWhite = Color.White
//    val gradientGrayWhite = Brush.verticalGradient(0f to colorGray, 1000f to colorWhite)
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
                    modifier = Modifier.background(colorGray)
                ) {
                    Text(
                        text = filteredMenu[index].label,
                        textAlign = TextAlign.Center,
                        modifier = Modifier.padding(Dimens.PaddingLarge),
                        color = Color.White
                    )
                }

            }

        }


    }
}

private fun getMenuList(): ArrayList<Menu> {
    val menus= arrayListOf<Menu>()
    menus.add(Menu("Pokedex"))
    menus.add(Menu("Moves"))
    menus.add(Menu("Abilities"))
    menus.add(Menu("Items"))
    menus.add(Menu("Locations"))
    menus.add(Menu("Type Charts"))
    return menus
}

private fun onClickMenu(context: Context, menu: String, navController: NavController) {
    navController.navigate(Screen.PokemonListScreen.route)
    Toast.makeText(context, menu, Toast.LENGTH_SHORT).show()
}