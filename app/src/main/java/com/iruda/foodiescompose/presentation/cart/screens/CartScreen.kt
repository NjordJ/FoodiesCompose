package com.iruda.foodiescompose.presentation.cart.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Card
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.graphics.toColorInt
import cafe.adriel.voyager.core.screen.Screen
import com.iruda.foodiescompose.R

class CartScreen : Screen {

    @Composable
    override fun Content() {
        CartView()
    }

    @Preview
    @Composable
    private fun CartView() {
        CartFoodList()
    }

    @Composable
    private fun CartFoodList() {
        LazyColumn {
            items(count = foodList.size) { index ->
                FoodItemCard(
                    food = foodList[index],
                    onRemoveClick = { /* handle remove click */ },
                    onAddClick = { /* handle add click */ }
                )
            }
        }
    }

    @Composable
    private fun FoodItemCard(food: Food, onRemoveClick: () -> Unit, onAddClick: () -> Unit) {
        Card(
            modifier = Modifier
                .padding(8.dp)
                .fillMaxWidth(),
            elevation = 8.dp
        ) {
            Row(
                modifier = Modifier.padding(16.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    painter = painterResource(id = food.imageRes),
                    contentDescription = "",
                    modifier = Modifier.size(96.dp)
                )
                Spacer(modifier = Modifier.width(16.dp))
                Column {
                    Text(text = food.name, fontWeight = FontWeight.Bold)
                    Spacer(modifier = Modifier.height(8.dp))
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        But(drawableResId = R.drawable.minus, {})
                        Spacer(modifier = Modifier.width(8.dp))
                        Text(text = "1", fontSize = 16.sp)
                        Spacer(modifier = Modifier.width(8.dp))
                        But(drawableResId = R.drawable.plus, {})
                        Spacer(modifier = Modifier.width(8.dp))
                        Text(text = "580", fontSize = 16.sp, textAlign = TextAlign.End)
                    }
                }
            }
        }
    }

    @Composable
    private fun QuantityButtons(drawableResId: Int) {
        Box(modifier = Modifier.background(color = Color("#F5F5F5".toColorInt()))) {
            Image(painter = painterResource(id = drawableResId),
                contentDescription = null,
                modifier = Modifier
                    .size(44.dp)
                    .clickable { println("Button Clicked!") })
        }
    }

    @Composable
    private fun But(drawableResId: Int, onClick: () -> Unit) {
        IconButton(
            onClick = onClick,
            modifier = Modifier.background(color = Color("#F5F5F5".toColorInt()))
        ) {
            Image(
                painter = painterResource(id = drawableResId),
                contentDescription = null,
                modifier = Modifier
                    .size(44.dp)
                    .clickable { println("Button Clicked!") },
                colorFilter = ColorFilter.tint(color = Color("#F15412".toColorInt()))
            )
        }
    }


    data class Food(val name: String, val imageRes: Int)

    private val foodList = listOf(
        Food("Food1", R.drawable.food),
        Food("Food2", R.drawable.food),
        Food("Food3", R.drawable.food),
        Food("Food4", R.drawable.food),
        Food("Food5", R.drawable.food),
        Food("Food6", R.drawable.food),
        Food("Food7", R.drawable.food),
        Food("Food8", R.drawable.food),
        Food("Food9", R.drawable.food),
        Food("Food10", R.drawable.food),
    )
}