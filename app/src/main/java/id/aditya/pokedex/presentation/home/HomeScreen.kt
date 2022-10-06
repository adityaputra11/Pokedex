package id.aditya.pokedex.presentation.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import id.aditya.pokedex.compose.Dimens
import id.aditya.pokedex.presentation.home.components.Header
import id.aditya.pokedex.presentation.home.components.Menus

@Composable
fun HomeScreen(
    navController: NavController
) {
    Surface {

        Column() {
            var searchText by rememberSaveable(stateSaver = TextFieldValue.Saver) {
                mutableStateOf(
                    TextFieldValue()
                )
            }
            Header(searchText = searchText, onSearchMenu = { searchText = it })
            Spacer(modifier = Modifier.padding(top = Dimens.PaddingLarge))
            Menus(navController = navController, searchText = searchText)
        }

    }
}
