package id.aditya.pokedex.presentation.home.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextDecoration
import id.aditya.pokedex.compose.Dimens

@Composable
fun Header(searchText:TextFieldValue, onSearchMenu:(TextFieldValue)->Unit) {

    val darkBlue = Color(0xFF4158D0)
    val lightSeal = Color(0xFF02B7BB)
    Card(
        shape = RoundedCornerShape(
            bottomEnd = Dimens.PaddingLarge,
            bottomStart = Dimens.PaddingLarge
        ),
    ) {
        Box(modifier = Modifier.background(Brush.verticalGradient(
            colors = listOf(
                darkBlue,
                lightSeal
            )
        ))) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight(0.25f)
                    .padding(Dimens.PaddingNormal),
                verticalArrangement = Arrangement.SpaceEvenly
            ) {
                Text(
                    text = "Pokédex",
                    fontSize = Dimens.TextLarge,
                    fontWeight = FontWeight.Bold,
                    color = Color.White
                )
                Text(text = "Cari Sesuatu", color = Color.White)
                Spacer(modifier = Modifier.padding(top = Dimens.PaddingSmall))
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
                                        text = "Search Pokemon, Move, Ability, Etc",
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
}

