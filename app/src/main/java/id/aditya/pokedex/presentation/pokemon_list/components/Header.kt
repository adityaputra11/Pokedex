package id.aditya.pokedex.presentation.pokemon_list.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextDecoration
import id.aditya.pokedex.compose.Dimens

@Composable
fun Header(searchText:TextFieldValue, onSearchMenu:(TextFieldValue)->Unit) {
    Card(shape = RoundedCornerShape(Dimens.PaddingSmall)) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.Red)
                .padding(Dimens.PaddingSmall)
        ) {
            Card(
                modifier = Modifier
                    .fillMaxWidth(),
                shape = RoundedCornerShape(Dimens.PaddingLarge)
            ) {
                BasicTextField(
                    value = searchText,
                    singleLine = true,
                    onValueChange = onSearchMenu,
                    modifier = Modifier
                        .padding(Dimens.PaddingNormal)
                        .fillMaxWidth()
                        .background(Color.White)
                        .padding(horizontal = Dimens.PaddingSmall),
                    textStyle = TextStyle(
                        fontSize = Dimens.TextSmall,
                        textDecoration = TextDecoration.None
                    ),
                    decorationBox = { innerTextField ->
                        Row() {
                            if (searchText.text.isEmpty()) {
                                Text(
                                    text = "Search Pokemon",
                                    fontSize = Dimens.TextSmall,
                                    textDecoration = TextDecoration.None
                                )
                            } else {
                                innerTextField()
                            }
                        }
                    }

                )
            }

        }
    }
}